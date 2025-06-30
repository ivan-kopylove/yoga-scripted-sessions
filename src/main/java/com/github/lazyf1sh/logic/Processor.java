package com.github.lazyf1sh.logic;

import com.github.ivan.kopylove.commons.*;
import com.github.lazyf1sh.domain.*;

import com.github.lazyf1sh.logic.phrase.builder.spi.*;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

import static java.util.concurrent.TimeUnit.SECONDS;

import org.slf4j.*;

public class Processor {


    private static final Logger LOGGER = LoggerFactory.getLogger(Processor.class);

    private final SessionParameters sessionParameters;
    private final ToFileSaver toFileSaver;
    private final ShellExecutor shellExecutor;
    private final SourceFileBuilderSpi sourceFileBuilderSpi;
    private final ShellExecutorParameters shellExecutorParameters;
    private final EditDistance ed = new EditDistance();

    public Processor(SessionParameters sessionParameters, ToFileSaver toFileSaver, ShellExecutor shellExecutor, SourceFileBuilderSpi sourceFileBuilderSpi, ShellExecutorParameters shellExecutorParameters) {
        this.sessionParameters = sessionParameters;
        this.toFileSaver = toFileSaver;
        this.shellExecutor = shellExecutor;
        this.sourceFileBuilderSpi = sourceFileBuilderSpi;
        this.shellExecutorParameters = shellExecutorParameters;
    }

    public void process() {
        LOGGER.info("executing processor");


        List<SourceFile> result = sourceFileBuilderSpi.build();

        ed(result);

        LOGGER.info("---");
        logLongestLines(result);
        LOGGER.info("---");

        logFilesWithBiggestNumberOfLines(result);
        LOGGER.info("---");
        logMostFrequentPhrases(result);
        LOGGER.info("---");
        logMissingEnLocalization(result);
        LOGGER.info("---");

        logEmptyEnLines(result);

        toFileSaver.save(result);
        execMerge();

        LOGGER.info("---");
        logStats(sessionParameters);
        LOGGER.info("---");
        logFilesWithBiggestNumberOfLines(result);
        LOGGER.info("---");
        logMostFrequentPhrases(result);
        LOGGER.info("---");
        logMissingEnLocalization(result);
        LOGGER.info("---");
        logLongestLines(result);
        LOGGER.info("---");

        shutDownGobblerExecutor(shellExecutorParameters);
    }

    private void ed(List<SourceFile> result) {
        List<String> lines = result
                .stream()
                .flatMap(val -> val.getLines().stream())
                .filter(line -> line.getLineType() == LineType.REGULAR)
                .filter(line -> line.en().isPresent())
                .map(line -> line.en().get())
                .filter(line -> line.length() > 20)
                .distinct()
                .collect(Collectors.toList());

        for (int i = 0; i < lines.size(); i++) {
            for (int j = 0; j < lines.size(); j++) {
                if (!lines.get(i).equals(lines.get(j))) {
                    int distance = ed.minDistance(lines.get(i), lines.get(j));
                    if (distance < 5) {
                        LOGGER.info("---");
                        LOGGER.info("distance: {}", distance);
                        LOGGER.info("line 1: {}", lines.get(i));
                        LOGGER.info("line 2: {}", lines.get(j));
                    }
                }
            }

        }
    }

    private static void logEmptyEnLines(List<SourceFile> result) {
        List<Line> emptyEn = result
                .stream()
                .flatMap(val -> val.getLines().stream())
                .filter(line -> line.getLineType() == LineType.REGULAR)
                .filter(line -> line.en().isPresent())
                .filter(line -> line.en().get().equals("") || line.en().get().equals(" "))
                .collect(Collectors.toList());


        if (!emptyEn.isEmpty()) {
            LOGGER.error("---");
            LOGGER.error("Empty en lines:");
            emptyEn.forEach(line -> {
                LOGGER.info(line.ru());
            });
            LOGGER.error("---");

            throw new RuntimeException("there are empty en lines");
        }
    }

    private static void logLongestLines(List<SourceFile> result) {
        LOGGER.info("Longest lines:");

        List<Line> lines = result
                .stream()
                .flatMap(val -> val.getLines().stream())
                .filter(line -> line.getLineType() == LineType.REGULAR)
                .filter(line -> line.en().isPresent())
                .sorted(Comparator.comparingInt(o -> o.en().get().length()))
                .collect(Collectors.toList());

        lines
                .stream()
                .skip(lines.size() - 20)
                .forEach(val -> LOGGER.info(val.en().get()));
    }

    private static void logMissingEnLocalization(List<SourceFile> result) {
        LOGGER.info("Missing EN localizations:");
        result
                .stream()
                .flatMap(val -> val.getLines().stream())
                .filter(line -> line.getLineType() == LineType.REGULAR)
                .filter(line -> line.en().isEmpty())
                .forEach(sourceFile -> LOGGER.info(sourceFile.ru()));
    }

    private void logStats(SessionParameters sessionParameters) {
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

    private void shutDownGobblerExecutor(ShellExecutorParameters sessionParameters) {
        ExecutorService executorService = sessionParameters.getStreamGobblerPool();
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(15, SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            LOGGER.error("gobbler shutdown error", e);
            executorService.shutdownNow();
        }
    }


    private static void logMostFrequentPhrases(List<SourceFile> result) {
        LOGGER.info("Most frequent phrases:");
        Set<Map.Entry<String, List<Line>>> entries = result
                .stream()
                .flatMap(sourceFile -> sourceFile.getLines().stream())
                .filter(line -> line.getLineType() == LineType.REGULAR)
                .filter(line -> line.en().isPresent())
                .collect(Collectors.groupingBy(line -> line.en().get()))
                .entrySet();

        entries.stream()
                .sorted(Comparator.comparingInt(o -> o.getValue().size()))
                .skip(entries.size() - 20)
                .toList()
                .reversed()
                .forEach(stringListEntry -> LOGGER.info(stringListEntry.getKey() + ": " + stringListEntry.getValue().size()));
    }

    private static void logFilesWithBiggestNumberOfLines(List<SourceFile> result) {
        LOGGER.info("Files with biggest number of lines:");
        result.stream()
                .sorted(Comparator.comparingInt(o -> o.getLines().size()))
                .skip(result.size() - 10)
                .toList()
                .reversed()
                .forEach(file -> LOGGER.info(file.getName() + ": " + file.getLines().size()));
    }

    private void execMerge() {
        shellExecutor.exec("for f in *.ogg; do echo \"file '$f'\" >> oggList.txt; done");
//        shellExecutor.exec("cmd.exe /c (for %i in (*.ogg) do @echo file '%i') > oggList.txt");
        shellExecutor.exec("ffmpeg -f concat -safe 0 -i oggList.txt -c copy oggFile.ogg");
        shellExecutor.exec("ffmpeg -i oggFile.ogg -vn -ar 44100 -ac 2 -b:a 192k " + sessionParameters.workingDir().getFileName() + "_yoga_session.mp3");
        shellExecutor.exec("rm *.ogg");
        shellExecutor.exec("rm oggList.txt");
    }
}
