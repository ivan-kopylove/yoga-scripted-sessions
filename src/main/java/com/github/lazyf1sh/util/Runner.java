package com.github.lazyf1sh.util;


import com.github.lazyf1sh.suits.*;

import java.io.IOException;
import java.util.List;

public final class Runner {

    private static final TextTrimmer TRIMMER = new TextTrimmer();
    private static final TextSplitter SPLITTER = new TextSplitter();
    private static final PauseConverter PAUSE_CONVERTER = new PauseConverter();
    private static final Translator TRANSLATOR = new Translator();

    public static void main(final String[] args) throws IOException {

        DeepLXClient deepLXClient = new DeepLXClient();
        String test = deepLXClient.translate("Тест");
        if (!"Test".equals(test)) {
            throw new RuntimeException("DeepLX returned unexpected result");
        }

        final StringBuilder result = new StringBuilder();

        result.append("sil<[1000]>\n");
        result.append("Старт.\n");
        result.append("sil<[40000]>\n");

        result.append("\n");
        result.append(new Disclaimer().build());
        result.append(new Requisite().build());
        result.append(new CommonIntro().build());


        final SuryaNamaskar session = new SuryaNamaskar();
//        final String session = hipsOpening();
//        final String session = bends();
        result.append(session.build());

        result.append(new Outro().build());
        result.append("\n");

//        final String translated = TRANSLATOR.translate(result.toString());
        final String distributedPauses = PAUSE_CONVERTER.distributePause(session.build());
        final String trimmed = TRIMMER.multipleTrim(distributedPauses);
        final List<String> piecesOfText = SPLITTER.split(trimmed);

        //save(piecesOfText);
    }


}
