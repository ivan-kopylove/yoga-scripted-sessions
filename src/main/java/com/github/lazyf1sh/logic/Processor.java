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

        printTopLines(result);
        topPhrases(result);

        toFileSaver.save(result);
        execMerge();

        logStats(sessionParameters);
        shutDownGobblerExecutor(shellExecutorParameters);
    }

    private void logStats(SessionParameters sessionParameters) {
        LOGGER.info("Cache hits: {}", sessionParameters.getCacheHits());
        LOGGER.info("Skipped by chance: {}", sessionParameters.getSkippedByChance());

        LOGGER.info("total: {} | ru: {} ({}%) | en: {} ({}%)", sessionParameters.getTotalLines(), sessionParameters.getRuLines(), (int) (sessionParameters.getRuLines() / (double) sessionParameters.getTotalLines() * 100), sessionParameters.getEnLines(), (int) (sessionParameters.getEnLines() / (double) sessionParameters.getTotalLines() * 100));
    }

    private  void shutDownGobblerExecutor(ShellExecutorParameters sessionParameters) {
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


    private static void topPhrases(List<SourceFile> result) {
        Set<Map.Entry<String, List<Line>>> entries = result
                .stream()
                .flatMap(sourceFile -> sourceFile.getLines().stream())
                .filter(line -> line.getLineType() == LineType.REGULAR)
                .filter(line -> line.en().isPresent())
                .collect(Collectors.groupingBy(line -> line.en().get()))
                .entrySet();

        entries.stream()
                .sorted(Comparator.comparingInt(o -> o.getValue().size()))
                .skip(entries.size() - 10)
                .toList()
                .reversed()
                .forEach(stringListEntry -> System.out.println(stringListEntry.getKey() + ": " + stringListEntry.getValue().size()));
    }

    private static void printTopLines(List<SourceFile> result) {
        result.stream()
                .sorted(Comparator.comparingInt(o -> o.getLines().size()))
                .skip(result.size() - 10)
                .toList()
                .reversed()
                .forEach(file -> System.out.println(file.getName() + ": " + file.getLines().size()));
    }

    private void execMerge() {
        shellExecutor.exec("cmd.exe /c (for %i in (*.ogg) do @echo file '%i') > oggList.txt");
        shellExecutor.exec("ffmpeg -f concat -safe 0 -i oggList.txt -c copy oggFile.ogg");
        shellExecutor.exec("ffmpeg -i oggFile.ogg -vn -ar 44100 -ac 2 -b:a 192k " + sessionParameters.workingDir()
                .getFileName() + ".mp3");
        shellExecutor.exec("cmd.exe /c del /S *.ogg");
        shellExecutor.exec("cmd.exe /c del /S oggList.txt");
    }
}
