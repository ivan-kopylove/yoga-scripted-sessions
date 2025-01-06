package com.github.lazyf1sh.logic;

import com.github.ivan.kopylove.commons.ShellExecutor;
import com.github.lazyf1sh.domain.Line;
import com.github.lazyf1sh.domain.SessionParameters;
import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.logic.voice.randomVoice.linePicker.spi.RegularTextToAudioFileSpi;
import java.io.*;
import static java.nio.file.Files.createDirectories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;

import static com.github.lazyf1sh.logic.voice.randomVoice.linePicker.usecase.RegularTextToAudioFileUseCase.FILE_FORMAT;

public class ToFileSaver {
    private static final Logger LOGGER = LoggerFactory.getLogger(ToFileSaver.class);



    private final SessionParameters sessionParameters;
    private final ShellExecutor shellExecutor;
    private final RegularTextToAudioFileSpi textAudioSave;

    public ToFileSaver(SessionParameters sessionParameters, ShellExecutor pauseGenerator, RegularTextToAudioFileSpi textAudioSave) {
        this.sessionParameters = sessionParameters;
        this.shellExecutor = pauseGenerator;
        this.textAudioSave = textAudioSave;
    }

    public void save(List<SourceFile> piecesOfText) {
        try {
            createDirectories(sessionParameters.workingDir());

            int rollingFileName = 0;

            List<Line> lines = piecesOfText
                    .stream()
                    .flatMap(src -> src.getLines().stream())
                    .filter(filterByChance())
                    .toList();


            for (Line line : lines) {
                switch (line.getLineType()) {
                    case REGULAR -> {
                        textAudioSave.save(new RegularTextToAudioFileSpi.Payload(line, rollingFileName));
                        rollingFileName++;
                        sessionParameters.totalLinesIncrement();
                    }
                    case SILENCE -> {
                        double seconds = (double) line.getPauseDuration() / 1000;
                        String command = String.format("ffmpeg -f lavfi -i anullsrc -t %s -c:a libopus %s",
                                seconds,
                                String.format(FILE_FORMAT, rollingFileName++));
                        shellExecutor.exec(command);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    private Predicate<Line> filterByChance() {
        return line -> {
            boolean saveLine = ThreadLocalRandom.current().nextDouble(0, 100) < line.chance();
            if (!saveLine) {
                sessionParameters.skippedByChanceIncrement();
            }
            return saveLine;
        };
    }
}
