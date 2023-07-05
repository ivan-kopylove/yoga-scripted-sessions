package com.github.lazyf1sh.util;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import static com.github.lazyf1sh.util.Cache.CACHE;
import static com.github.lazyf1sh.yandex.speech.api.YandexSpeechSynthesisAPI.YANDEX_API_HITS;
import static java.nio.file.Files.createDirectories;
import static java.util.UUID.randomUUID;

public final class Runner {

    public static void main(final String[] args) throws IOException, InterruptedException, ExecutionException, TimeoutException, NoSuchAlgorithmException {
        DeepLXClient deepLXClient = new DeepLXClient();
        String test = deepLXClient.translate("Тест");
        if (!"Test".equals(test)) {
            throw new RuntimeException("DeepLX returned unexpected result");
        }

        createDirectories(Paths.get(CACHE));
        Path directories = createDirectories(Paths.get(randomUUID().toString()));

        ApplicationWideParameters applicationWideParameters = new ApplicationWideParameters().workingDir(directories);

        new Processor(new ToFileSaver(applicationWideParameters), new ShellExecutor(applicationWideParameters)).process();

        System.out.printf("Yandex API hits: %s%n", YANDEX_API_HITS);
    }


}
