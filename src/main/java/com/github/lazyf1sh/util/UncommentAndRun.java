package com.github.lazyf1sh.util;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.github.lazyf1sh.suits.AlpenvillaYogaIntro;
import com.github.lazyf1sh.suits.Bends;
import com.github.lazyf1sh.suits.HipsOpening;
import com.github.lazyf1sh.suits.SuryaNamaskar;
import com.github.lazyf1sh.yandex.speech.api.YandexSpeechSynthesisAPI;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public final class UncommentAndRun {
    public static void main(final String[] args) throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        final YogaConfig yogaConfig = objectMapper.readValue(new File("src/main/resources/yoga.config.yml"), YogaConfig.class);

        final SuryaNamaskar suryaNamaskar = new SuryaNamaskar(yogaConfig);
        final HipsOpening hipsOpening = new HipsOpening(yogaConfig);
        final Bends bends = new Bends(yogaConfig);
        final AlpenvillaYogaIntro alpenvillaYogaIntro = new AlpenvillaYogaIntro(yogaConfig);

        String content;


//        content = new Disclaimer(yogaConfig).build();
//        content = alpenvillaYogaIntro.build();
//        content = suryaNamaskar.buildSuryaSession();
//        content = hipsOpening.buildHipsOpeningSession();
        content = bends.build();


        content = multipleTrim(content);

        final ArrayList<String> piecesOfText = new ArrayList<>();
        splitIntoPieces(content, piecesOfText);

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

    private static String multipleTrim(String content) {
        content = content.replace("\r\n", " ");
        content = content.replace("\n", " ");
        content = content.replace("\r", " ");
        for (int i = 0; i < 10; i++) {
            content = content.replace("  ", " ");
        }
        return content;
    }


    private static void splitIntoPieces(final String content, final List<String> result) {
        if (content.length() < 1) {
            return;
        }
        int nextChunk = 4800;

        if (content.length() < nextChunk) {
            result.add(content);
            return;
        }

        if (nextChunk > content.length()) {
            nextChunk = content.length();
        }

        int fromPoint = content.indexOf(".", nextChunk + 1) + 1;
        if (fromPoint < 0) {
            fromPoint = nextChunk;
        }
        if (fromPoint > content.length()) {
            fromPoint = nextChunk;
        }

        final String whole = content.substring(fromPoint);
        final String chunk = content.substring(0, fromPoint);
        result.add(chunk);

        splitIntoPieces(whole, result);
    }
}
