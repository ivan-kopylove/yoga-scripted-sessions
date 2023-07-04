package com.github.lazyf1sh.util;


import com.github.lazyf1sh.domain.Line;
import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.suits.CommonIntro;
import com.github.lazyf1sh.suits.Disclaimer;
import com.github.lazyf1sh.suits.Outro;
import com.github.lazyf1sh.suits.Requisite;

import java.io.IOException;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import static com.github.lazyf1sh.suits.HipsOpening.hipsOpening;
import static com.github.lazyf1sh.util.Cache.CACHE;
import static com.github.lazyf1sh.util.ToFileSaver.save;
import static com.github.lazyf1sh.yandex.speech.api.YandexSpeechSynthesisAPI.YANDEX_API_HITS;
import static java.nio.file.Files.createDirectories;

public final class Runner {

    private static final Translator TRANSLATOR = new Translator();

    public static void main(final String[] args) throws IOException, InterruptedException, ExecutionException, TimeoutException, NoSuchAlgorithmException {


        DeepLXClient deepLXClient = new DeepLXClient();
        String test = deepLXClient.translate("Тест");
        if (!"Test".equals(test)) {
            throw new RuntimeException("DeepLX returned unexpected result");
        }

        createDirectories(Paths.get(CACHE));

        final List<SourceFile> result = new ArrayList<>();

        result.add(new SourceFile(null, List.of(new Line("sil<[1000]>"))));
        result.add(new SourceFile(null, List.of(new Line("{\"ru\": \"Старт.\"}"))));
        result.add(new SourceFile(null, List.of(new Line("sil<[40000]>"))));

        result.add(new Disclaimer().build());
        result.add(new Requisite().build());
        result.addAll(new CommonIntro().build());

//        final List<SourceFile> session = suryaNamaskar();
        final List<SourceFile> session = hipsOpening();
//        final List<SourceFile> session = bends();
        result.addAll(session);

        result.add(new Outro().build());

//        TRANSLATOR.enrichWitTranslation(result);

        //final List<SourceFile> distributedPauses = PAUSE_CONVERTER.distributePause(result);

        save(result);

        System.out.printf("Yandex API hits: %s%n", YANDEX_API_HITS);
    }


}
