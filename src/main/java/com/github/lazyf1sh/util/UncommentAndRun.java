package com.github.lazyf1sh.util;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.github.lazyf1sh.suits.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.github.lazyf1sh.util.ToFileSaver.save;

public final class UncommentAndRun {

    private static final TextTrimmer trimmer = new TextTrimmer();
    private static final TextSplitter splitter = new TextSplitter();

    public static void main(final String[] args) throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        final YogaConfig yogaConfig = objectMapper.readValue(new File("src/main/resources/yoga.config.yml"), YogaConfig.class);

//        final SuryaNamaskar suryaNamaskar = new SuryaNamaskar(yogaConfig);
        final HipsOpening hipsOpening = new HipsOpening(yogaConfig);
//        final Bends bends = new Bends(yogaConfig);

        final StringBuilder result = new StringBuilder();

//        content = suryaNamaskar.buildSuryaSession();
//        content = hipsOpening.buildHipsOpeningSession();


        result.append("Старт.\n");
        result.append("sil <[20000]>\n");

        result.append(hipsOpening.build());


        final String trimmed = trimmer.multipleTrim(result.toString());
        final List<String> piecesOfText = splitter.split(trimmed);

        save(piecesOfText);
    }


}
