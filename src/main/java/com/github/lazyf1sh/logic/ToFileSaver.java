package com.github.lazyf1sh.logic;

import com.github.ivan.kopylove.commons.ShellExecutor;
import com.github.ivan.kopylove.commons.client.yandex.api.speech.Voice;
import com.github.lazyf1sh.domain.Line;
import com.github.lazyf1sh.domain.SessionParameters;
import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.logic.resource.files.saver.spi.SaveFileSpi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeoutException;

import static com.github.ivan.kopylove.commons.client.yandex.api.speech.Voice.JOHN;
import static com.github.ivan.kopylove.commons.client.yandex.api.speech.Voice.randomRuVoice;

public class ToFileSaver {
    private static final Logger LOGGER = LoggerFactory.getLogger(ToFileSaver.class);

    private static final String FILE_FORMAT = "%05d.ogg";
    private final VoiceProvider voiceProvider;
    private final SessionParameters sessionParameters;
    private final ShellExecutor shellExecutor;
    private final SaveFileSpi saveFileSpi;
    private final ThreadLocalRandom THREAD_LOCAL_RANDOM = ThreadLocalRandom.current();

    public ToFileSaver(SessionParameters sessionParameters, ShellExecutor pauseGenerator, VoiceProvider voiceProvider, SaveFileSpi saveFileSpi) {
        this.sessionParameters = sessionParameters;
        this.shellExecutor = pauseGenerator;
        this.voiceProvider = voiceProvider;
        this.saveFileSpi = saveFileSpi;
    }

    public void save(List<SourceFile> piecesOfText) throws IOException, InterruptedException, ExecutionException, TimeoutException {
        int rollingFileName = 0;
        Voice ruMainVoice = randomRuVoice();
        int voiceLines = THREAD_LOCAL_RANDOM.nextInt(15, 35);

        for (SourceFile sourceFile : piecesOfText) {
            for (Line line : sourceFile.getLines()) {
                if (THREAD_LOCAL_RANDOM.nextDouble(0, 100) > line.chance()) {
                    sessionParameters.skippedByChanceIncrement();
                    continue;
                }

                if (voiceLines < 1) {
                    voiceLines = ThreadLocalRandom.current().nextInt(10, 30);
                    ruMainVoice = randomRuVoice();
                }

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
                            byte[] voice = voiceProvider.get(line.ru(), ruMainVoice);
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

                voiceLines--;
            }
        }
    }
}
