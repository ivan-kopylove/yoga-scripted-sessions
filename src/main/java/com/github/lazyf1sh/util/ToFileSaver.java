package com.github.lazyf1sh.util;

import com.github.lazyf1sh.yandex.speech.api.YandexSpeechSynthesisAPI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ToFileSaver {

    public static void save(List<String> piecesOfText) throws IOException {
        for (int i = 0, piecesOfTextSize = piecesOfText.size(); i < piecesOfTextSize; i++) {
            final String text = piecesOfText.get(i);
            final byte[] generated = YandexSpeechSynthesisAPI.generate(text);
            saveSingle(String.format("%02d.ogg", i), generated);
        }
    }

    private static void saveSingle(final String filename, final byte[] content) throws IOException {
        final Path directory = Files.createDirectories(Paths.get("output-ogg"));

        final Path file = Paths.get(directory.toString(), filename);

        Files.write(file, content);
    }
}
