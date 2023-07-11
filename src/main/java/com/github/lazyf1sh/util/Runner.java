package com.github.lazyf1sh.util;


import com.github.lazyf1sh.suits.SuryaNamaskar;
import com.github.lazyf1sh.yandex.speech.api.YandexSpeechSynthesisAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeoutException;

import static com.github.lazyf1sh.util.Cache.CACHE;
import static java.nio.file.Files.createDirectories;
import static java.util.concurrent.TimeUnit.SECONDS;

public final class Runner {

    private static final Logger LOGGER = LoggerFactory.getLogger(Runner.class);


    public static void main(final String[] args) throws IOException, InterruptedException, ExecutionException, TimeoutException, NoSuchAlgorithmException {
        LOGGER.info("starting");
        SessionParameters sessionParameters = new SessionParameters();
        sessionParameters.setTranslateHaphazardly(false);
        sessionParameters.session(SuryaNamaskar.class);

        if (sessionParameters.isTranslateHaphazardly()) {
            DeepLXClient deepLXClient = new DeepLXClient();
            String test = deepLXClient.translate("Тест");
            if (!"Test".equals(test)) {
                throw new RuntimeException("DeepLX returned unexpected result");
            }
        }

        createDirectories(Paths.get(CACHE));
        Path directories = createDirectories(Paths.get(sessionParameters.session().getSimpleName() + "_" + Instant.now().toString().replace(":", "_")));
        sessionParameters.workingDir(directories);

        ShellExecutor shellExecutor = new ShellExecutor(sessionParameters);

        LOGGER.info("executing processor");
        new Processor(sessionParameters,
                new ToFileSaver(sessionParameters,
                        shellExecutor,
                        new VoiceProvider(new YandexSpeechSynthesisAPI(sessionParameters), new Cache(sessionParameters))),
                shellExecutor,
                new Translator()).process();

        LOGGER.info("Yandex API hits: {}", sessionParameters.getYandexApiHits());
        LOGGER.info("Cache hits: {}", sessionParameters.getCacheHits());
        LOGGER.info("Yandex API retries: {}", sessionParameters.getYandexApiRetries());
        LOGGER.info("Skipped by chance: {}", sessionParameters.getSkippedByChance());
        shutDownGobblerExecutor(sessionParameters);
    }

    private static void shutDownGobblerExecutor(SessionParameters sessionParameters) {
        ExecutorService executorService = sessionParameters.getStreamGobblerPool();
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
