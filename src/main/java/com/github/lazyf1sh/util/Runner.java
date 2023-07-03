package com.github.lazyf1sh.util;


import com.github.lazyf1sh.domain.Line;
import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.suits.*;

import java.io.IOException;
import java.util.ArrayList;
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

        final List<SourceFile> result = new ArrayList<>();

        result.add(new SourceFile(null, List.of(new Line("sil<[1000]>"))));
        result.add(new SourceFile(null, List.of(new Line("{\"ru\": \"Старт.\"}"))));
        result.add(new SourceFile(null, List.of(new Line("sil<[40000]>"))));

        result.add(new Disclaimer().build());
        result.add(new Requisite().build());
        result.addAll(new CommonIntro().build());

        final SuryaNamaskar session = new SuryaNamaskar();
//        final String session = hipsOpening();
//        final String session = bends();
        result.addAll(session.build());

        result.add(new Outro().build());

        TRANSLATOR.enrichWitTranslation(result);
        final List<SourceFile> distributedPauses = PAUSE_CONVERTER.distributePause(result);
        int i = 0;
//        final String trimmed = TRIMMER.multipleTrim(distributedPauses);
//        final List<String> piecesOfText = SPLITTER.split(trimmed);

        //save(piecesOfText);
    }


}
