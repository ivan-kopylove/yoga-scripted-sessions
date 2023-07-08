package com.github.lazyf1sh.util;


import com.github.lazyf1sh.suits.HipsOpening;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeoutException;

import static com.github.lazyf1sh.util.Cache.CACHE;
import static com.github.lazyf1sh.yandex.speech.api.YandexSpeechSynthesisAPI.YANDEX_API_HITS;
import static java.nio.file.Files.createDirectories;
import static java.util.concurrent.TimeUnit.SECONDS;

public final class Runner {

    public static void main(final String[] args) throws IOException, InterruptedException, ExecutionException, TimeoutException, NoSuchAlgorithmException {

        ApplicationWideParameters applicationWideParameters = new ApplicationWideParameters();
        applicationWideParameters.setTranslateHaphazardly(false);
        applicationWideParameters.session(HipsOpening.class);

        if (applicationWideParameters.isTranslateHaphazardly()) {
            DeepLXClient deepLXClient = new DeepLXClient();
            String test = deepLXClient.translate("Тест");
            if (!"Test".equals(test)) {
                throw new RuntimeException("DeepLX returned unexpected result");
            }
        }

        createDirectories(Paths.get(CACHE));
        Path directories = createDirectories(Paths.get(applicationWideParameters.session().getSimpleName() + "_" + Instant.now().toString().replace(":", "_")));
        applicationWideParameters.workingDir(directories);

        new Processor(applicationWideParameters, new ToFileSaver(applicationWideParameters, new PauseGenerator(applicationWideParameters)), new ShellExecutor(applicationWideParameters)).process();

        System.out.printf("Yandex API hits: %s%n", YANDEX_API_HITS);
        shutDownGobblerExecutor(applicationWideParameters);
    }

    private static void shutDownGobblerExecutor(ApplicationWideParameters applicationWideParameters) {
        ExecutorService executorService = applicationWideParameters.getStreamGobblerPool();
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(15, SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }


}
