package com.github.lazyf1sh.util;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.github.lazyf1sh.suits.SuryaNamaskar;

import java.io.IOException;
import java.util.List;

import static com.github.lazyf1sh.util.ToFileSaver.save;

public final class Runner {

    private static final TextTrimmer TRIMMER = new TextTrimmer();
    private static final TextSplitter SPLITTER = new TextSplitter();

    public static void main(final String[] args) throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

        final SuryaNamaskar session = new SuryaNamaskar();
//        final HipsOpening session = new HipsOpening();
//        final String session = bends();

        final StringBuilder result = new StringBuilder();

        result.append("sil<[1000]>\n");
        result.append("Старт.\n");
        result.append("sil<[20000]>\n");

        result.append(session.build());


        final String trimmed = TRIMMER.multipleTrim(result.toString());
        final List<String> piecesOfText = SPLITTER.split(trimmed);

        save(piecesOfText);
    }


}
