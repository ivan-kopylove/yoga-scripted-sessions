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
    private static final PauseConverter PAUSE_CONVERTER = new PauseConverter();
    private static final TeleprompterConverter TELEPROMPTER_CONVERTER = new TeleprompterConverter();

    public static void main(final String[] args) throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

        final SuryaNamaskar session = new SuryaNamaskar();
//        final HipsOpening session = new HipsOpening();
//        final String session = bends();

        final StringBuilder result = new StringBuilder();

        result.append("sil<[1000]>\n");
        result.append("Старт.\n");
        result.append("sil<[40000]>\n");

        result.append(session.build());


        final String distributedPauses = PAUSE_CONVERTER.distributePause(result.toString());
        final String telepromter = TELEPROMPTER_CONVERTER.convert(result.toString());

        final String trimmed = TRIMMER.multipleTrim(distributedPauses);
        final List<String> piecesOfText = SPLITTER.split(trimmed);

        save(piecesOfText);
    }


}
