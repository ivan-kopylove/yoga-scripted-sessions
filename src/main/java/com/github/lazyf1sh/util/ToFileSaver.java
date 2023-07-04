package com.github.lazyf1sh.util;

import com.github.lazyf1sh.domain.Line;
import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.yandex.speech.api.Voice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import static com.github.lazyf1sh.yandex.speech.api.Voice.*;
import static java.nio.file.Files.createDirectories;
import static java.util.UUID.randomUUID;

public class ToFileSaver {

    private final static PauseGenerator PAUSE_GENERATOR = new PauseGenerator();
    private final static VoiceProvider VOICE_PROVIDER = new VoiceProvider();
    private final static String FILE_FORMAT = "%05d.ogg";


    public static void save(List<SourceFile> piecesOfText) throws IOException, InterruptedException, ExecutionException, TimeoutException, NoSuchAlgorithmException {

        final Path directory = createDirectories(Paths.get(randomUUID().toString()));

        int i = 0;
        Voice ruMainVoice = ERMIL;
        for (SourceFile sourceFile : piecesOfText) {
            for (Line line : sourceFile.getLines()) {
                ruMainVoice = line.switchRuMainVoice() != PREVIOUS ? line.switchRuMainVoice() : ruMainVoice;

                switch (line.getLineType()) {
                    case REGULAR:
                        if (line.de().isPresent()) {

                            final byte[] voice = VOICE_PROVIDER.get(line.de().orElseThrow(), LEA);

                            saveSingle(String.format(FILE_FORMAT, i++), voice, directory);
                        } else if (line.en().isPresent()) {
                            final byte[] voice = VOICE_PROVIDER.get(line.en().orElseThrow(), JOHN);

                            saveSingle(String.format(FILE_FORMAT, i++), voice, directory);
                        } else {
                            final byte[] voice = VOICE_PROVIDER.get(line.ru(), ruMainVoice);

                            saveSingle(String.format(FILE_FORMAT, i++), voice, directory);
                        }
                        break;
                    case PAUSE:
                        PAUSE_GENERATOR.generate(line.getPauseDuration(), String.format(FILE_FORMAT, i++), directory);
                        break;
                }

            }
        }
    }

    private static void saveSingle(final String filename, final byte[] content, Path directory) throws IOException {


        final Path file = Paths.get(directory.toString(), filename);

        Files.write(file, content);


    }
}
