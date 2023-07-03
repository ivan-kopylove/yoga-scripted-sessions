package com.github.lazyf1sh.util;


import com.github.lazyf1sh.suits.SuryaNamaskar;
import com.github.lazyf1sh.yandex.speech.api.DeepLXClient;

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
        if(!"Test".equals(test))
        {
            throw new RuntimeException("DeepLX has returned unexpected result");
        }

        final SuryaNamaskar session = new SuryaNamaskar();
//        final HipsOpening session = new HipsOpening();
//        final String session = bends();

        final StringBuilder result = new StringBuilder();

        result.append("sil<[1000]>\n");
        result.append("Старт.\n");
        result.append("sil<[40000]>\n");

        result.append(session.build());

        final String translated = TRANSLATOR.translate(result.toString());
        final String distributedPauses = PAUSE_CONVERTER.distributePause(translated);
        final String trimmed = TRIMMER.multipleTrim(distributedPauses);
        final List<String> piecesOfText = SPLITTER.split(trimmed);

        //save(piecesOfText);
    }


}
