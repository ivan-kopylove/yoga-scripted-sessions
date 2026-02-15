package com.github.lazyf1sh.logic;

import com.github.ivan.kopylove.commons.CmdShellExecutor;
import com.github.ivan.kopylove.commons.ShellExecutorParameters;
import com.github.lazyf1sh.domain.Line;
import com.github.lazyf1sh.domain.LineLanguage;
import com.github.lazyf1sh.domain.SessionParameters;
import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.logic.phrase.builder.spi.SourceFileBuilderSpi;
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;

import static com.github.lazyf1sh.domain.LineType.REGULAR;
import static java.util.concurrent.TimeUnit.SECONDS;

public class Processor
{

    private static final Logger LOGGER = LoggerFactory.getLogger(Processor.class);

    private final SessionParameters       sessionParameters;
    private final ToFileSaver             toFileSaver;
    private final CmdShellExecutor        shellExecutor;
    private final SourceFileBuilderSpi    sourceFileBuilderSpi;
    private final ShellExecutorParameters shellExecutorParameters;
    private final EditDistance            ed         = new EditDistance();
    private final LevenshteinDistance     levenstein = LevenshteinDistance.getDefaultInstance();

    public Processor(SessionParameters sessionParameters, ToFileSaver toFileSaver, CmdShellExecutor shellExecutor, SourceFileBuilderSpi sourceFileBuilderSpi, ShellExecutorParameters shellExecutorParameters)
    {
        this.sessionParameters = sessionParameters;
        this.toFileSaver = toFileSaver;
        this.shellExecutor = shellExecutor;
        this.sourceFileBuilderSpi = sourceFileBuilderSpi;
        this.shellExecutorParameters = shellExecutorParameters;
    }

    public void process()
    {
        LOGGER.info("executing processor");

        List<SourceFile> result = sourceFileBuilderSpi.build();

        logEditDistance(result);

        LOGGER.info("---");
        logLongestLines(result);
        LOGGER.info("---");

        logFilesWithBiggestNumberOfLines(result);
        LOGGER.info("---");
        logMostFrequentPhrases(result);
        LOGGER.info("---");
        logMissingEnLocalization(result);
        LOGGER.info("---");

        logEmptyLines(result);

        toFileSaver.save(result);
        execMerge();

        LOGGER.info("---");

        logFilesWithBiggestNumberOfLines(result);
        LOGGER.info("---");
        logMostFrequentPhrases(result);
        LOGGER.info("---");
        logMissingEnLocalization(result);
        LOGGER.info("---");
        logLongestLines(result);
        LOGGER.info("---");
        logStats(sessionParameters);
        LOGGER.info("---");

        shutDownGobblerExecutor(shellExecutorParameters);
    }

    private void logEditDistance(List<SourceFile> result)
    {
        List<String> lines = result.stream()
                                   .flatMap(val -> val.getLines().stream())
                                   .filter(line -> line.getLineType() == REGULAR)
                                   .filter(line -> line.getLineByLanguage(sessionParameters.getLineLanguage()).isPresent())
                                   .map(line -> line.getLineByLanguage(sessionParameters.getLineLanguage()).get())
                                   .filter(line -> line.length() > 15)
                                   .distinct()
                                   .collect(Collectors.toList());

        for (int i = 0; i < lines.size(); i++)
        {
            for (int j = 0; j < lines.size(); j++)
            {
                if (!lines.get(i).equals(lines.get(j)))
                {
                    double distance = levenstein.apply(lines.get(i), lines.get(j));
                    if (distance < 6)
                    {
                        LOGGER.info("---");
                        LOGGER.info("distance: {}", distance);
                        LOGGER.info("line 1: {}", lines.get(i));
                        LOGGER.info("line 2: {}", lines.get(j));
                    }
                }
            }
        }
    }

    private void logStats(SessionParameters sessionParameters)
    {
        LOGGER.info("Statistics:");

        LOGGER.info("Cache hits: {}", sessionParameters.getCacheHits());
        LOGGER.info("Cache misses: {}", sessionParameters.getCacheOverwrites());
        LOGGER.info("Skipped by chance: {}", sessionParameters.getSkippedByChance());

        int totalLines = sessionParameters.getTotalLines();
        int ruLines = sessionParameters.getRuLines();
        int enLines = sessionParameters.getEnLines();
        int ruPercent = (int) (ruLines / (double) totalLines * 100);
        int enPercent = (int) (enLines / (double) totalLines * 100);
        LOGGER.info("total: {} | ru: {} ({}%) | en: {} ({}%)", totalLines, ruLines, ruPercent, enLines, enPercent);
    }

    private void shutDownGobblerExecutor(ShellExecutorParameters sessionParameters)
    {
        ExecutorService executorService = sessionParameters.getStreamGobblerPool();
        executorService.shutdown();
        try
        {
            if (!executorService.awaitTermination(15, SECONDS))
            {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e)
        {
            LOGGER.error("gobbler shutdown error", e);
            executorService.shutdownNow();
        }
    }

    private void execMerge()
    {
        String os = System.getProperty("os.name");

        if (os.toLowerCase().contains("windows"))
        {
            execMergeOnWindows();
        } else
        {
            execMergeOnLinux();
        }
    }

    private void execMergeOnLinux()
    {
        shellExecutor.exec("for f in *.ogg; do echo \"file '$f'\" >> oggList.txt; done");
        shellExecutor.exec(ffmpegConcat());
        shellExecutor.exec(ffmpegMerge());
        shellExecutor.exec("rm *.ogg");
        shellExecutor.exec("rm oggList.txt");
    }

    private void execMergeOnWindows()
    {
        Path fileName = sessionParameters.getWorkingDir().getFileName();

        shellExecutor.exec("cmd.exe /c (for %i in (*.ogg) do @echo file '%i') > oggList.txt");
        shellExecutor.exec(ffmpegConcat());
        shellExecutor.exec(ffmpegMerge());
        shellExecutor.exec("cmd.exe /c del /S *.ogg");
        shellExecutor.exec("cmd.exe /c del /S oggList.txt");
    }

    private static String ffmpegConcat()
    {
        return "ffmpeg -f concat -safe 0 -i oggList.txt -c copy oggFile.ogg";
    }

    private String ffmpegMerge()
    {
        Path fileName = sessionParameters.getWorkingDir().getFileName();
        LineLanguage language = sessionParameters.getLineLanguage();

        return "ffmpeg -i oggFile.ogg -vn -ar 44100 -ac 2 -b:a 192k " + fileName + "_yoga_session_ " + language.name() + ".mp3";
    }

    private void logEmptyLines(List<SourceFile> result)
    {
        LineLanguage lineLanguage = sessionParameters.getLineLanguage();

        List<Line> empties = result.stream()
                                   .flatMap(val -> val.getLines().stream())
                                   .filter(line -> line.getLineType() == REGULAR)
                                   .filter(line -> line.getLineByLanguage(lineLanguage).isPresent())
                                   .filter(line -> line.getLineByLanguage(lineLanguage).get()
                                                       .equals("") || line.getLineByLanguage(lineLanguage)
                                                                          .get()
                                                                          .equals(" "))
                                   .collect(Collectors.toList());


        if (!empties.isEmpty())
        {
            LOGGER.error("---");
            LOGGER.error("Empty " + lineLanguage + " lines:");
            empties.forEach(line -> {
                LOGGER.info(line.getNode());
            });
            LOGGER.error("---");

            throw new RuntimeException("there are empty " + lineLanguage + " lines");
        }
    }

    private void logLongestLines(List<SourceFile> result)
    {
        LOGGER.info("Longest res:");

        List<Line> res = result.stream()
                               .flatMap(val -> val.getLines().stream())
                               .filter(line -> line.getLineType() == REGULAR)
                               .filter(line -> line.getLineByLanguage(sessionParameters.getLineLanguage()).isPresent())
                               .sorted(Comparator.comparingInt(o -> o.getLineByLanguage(sessionParameters.getLineLanguage())
                                                                     .get()
                                                                     .length()))
                               .collect(Collectors.toList());

        res
                .stream()
                .skip(res.size() - 20)
                .forEach(val -> LOGGER.info(val.getLineByLanguage(sessionParameters.getLineLanguage()).get()));
    }

    private void logMissingEnLocalization(List<SourceFile> result)
    {
        LineLanguage lineLanguage = sessionParameters.getLineLanguage();

        List<Line> list = result.stream()
                                .flatMap(val -> val.getLines().stream())
                                .filter(Line::isRegularLine)
                                .filter(line -> line.getLineByLanguage(lineLanguage).isEmpty())
                                .toList();

        if(!list.isEmpty())
        {
            LOGGER.error("---");
            String msg = "Missing localizations for " + lineLanguage + " :";
            LOGGER.error(msg);

            list
                    .forEach(line -> LOGGER.info(line.getNode()));

            throw new RuntimeException(msg);
        }

    }

    private void logMostFrequentPhrases(List<SourceFile> result)
    {
        LOGGER.info("The most frequent phrases:");
        Set<Map.Entry<String, List<Line>>> entries = result.stream()
                                                           .flatMap(sourceFile -> sourceFile.getLines().stream())
                                                           .filter(line -> line.getLineType() == REGULAR)
                                                           .filter(line -> line.getLineByLanguage(sessionParameters.getLineLanguage())
                                                                               .isPresent())
                                                           .collect(Collectors.groupingBy(line -> line.getLineByLanguage(sessionParameters.getLineLanguage())
                                                                                                      .get()))
                                                           .entrySet();

        entries.stream().sorted(Comparator.comparingInt(o -> o.getValue().size())).skip(entries.size() - 20).toList().reversed().forEach(
                stringListEntry -> LOGGER.info(stringListEntry.getKey() + ": " + stringListEntry.getValue().size()));
    }

    private static void logFilesWithBiggestNumberOfLines(List<SourceFile> result)
    {
        LOGGER.info("Files with the biggest number of lines:");
        result.stream()
              .sorted(Comparator.comparingInt(o -> o.getLines().size()))
              .skip(result.size() - 10)
              .toList()
              .reversed()
              .forEach(file -> LOGGER.info(file.getName() + ": " + file.getLines().size()));
    }
}
