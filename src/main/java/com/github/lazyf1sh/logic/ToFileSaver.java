package com.github.lazyf1sh.logic;

import com.github.ivan.kopylove.commons.ShellExecutor;
import com.github.ivan.kopylove.commons.client.yandex.api.speech.Voice;
import com.github.lazyf1sh.domain.Line;
import com.github.lazyf1sh.domain.SessionParameters;
import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.logic.resource.files.saver.spi.SaveFileSpi;
import com.github.lazyf1sh.logic.voice.spi.RandomRuVoicePickerSpi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeoutException;
import java.util.function.Predicate;

import static com.github.ivan.kopylove.commons.client.yandex.api.speech.Voice.JOHN;
import static com.github.ivan.kopylove.commons.client.yandex.api.speech.Voice.randomRuVoice;

public class ToFileSaver {
    private static final Logger LOGGER = LoggerFactory.getLogger(ToFileSaver.class);

    private static final String FILE_FORMAT = "%05d.ogg";
    private final VoiceProvider voiceProvider;
    private final SessionParameters sessionParameters;
    private final ShellExecutor shellExecutor;
    private final SaveFileSpi saveFileSpi;
    private final RandomRuVoicePickerSpi randomRuVoicePickerSpi;

    public ToFileSaver(SessionParameters sessionParameters, ShellExecutor pauseGenerator, VoiceProvider voiceProvider, SaveFileSpi saveFileSpi, RandomRuVoicePickerSpi randomRuVoicePickerSpi) {
        this.sessionParameters = sessionParameters;
        this.shellExecutor = pauseGenerator;
        this.voiceProvider = voiceProvider;
        this.saveFileSpi = saveFileSpi;
        this.randomRuVoicePickerSpi = randomRuVoicePickerSpi;
    }

    public void save(List<SourceFile> piecesOfText) {
        int rollingFileName = 0;

        List<Line> lines = piecesOfText
                .stream()
                .flatMap(src -> src.getLines().stream())
                .filter(filterByChance())
                .toList();


        for (Line line : lines) {
            switch (line.getLineType()) {
                case REGULAR -> {
                    if (line.en().isPresent()) {
                        byte[] voice = voiceProvider.get(line.en().orElseThrow(), JOHN);
                        saveFileSpi.saveFile(
                                new SaveFileSpi.Payload(String.format(FILE_FORMAT, rollingFileName++),
                                        voice,
                                        sessionParameters.workingDir()));
                        sessionParameters.enLinesIncrement();
                    } else {

                        byte[] voice = voiceProvider.get(line.ru(), randomRuVoicePickerSpi.randomRuVoice());
                        saveFileSpi.saveFile(
                                new SaveFileSpi.Payload(String.format(FILE_FORMAT, rollingFileName++),
                                        voice,
                                        sessionParameters.workingDir()));
                        sessionParameters.ruLinesIncrement();
                    }
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
    }

    private Predicate<Line> filterByChance() {
        return line -> {
            boolean skipLine = ThreadLocalRandom.current().nextDouble(0, 100) < line.chance();
            if (skipLine) {
                sessionParameters.skippedByChanceIncrement();
            }
            return skipLine;
        };
    }
}
