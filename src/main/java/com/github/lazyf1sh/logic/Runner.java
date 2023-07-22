package com.github.lazyf1sh.logic;

import com.github.lazyf1sh.api.deeplx.DeepLXClient;
import com.github.lazyf1sh.api.yandex.YandexSpeechSynthesisAPI;
import com.github.lazyf1sh.asanas.named.Bends;
import com.github.lazyf1sh.domain.SessionParameters;
import com.github.lazyf1sh.util.ShellExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeoutException;

import static com.github.lazyf1sh.logic.Cache.CACHE;
import static java.nio.file.Files.createDirectories;
import static java.time.Instant.now;
import static java.util.concurrent.TimeUnit.SECONDS;

public final class Runner
{
    private static final Logger LOGGER = LoggerFactory.getLogger(Runner.class);

    private Runner() {}

    public static void main(final String[] args) throws IOException, InterruptedException, ExecutionException, TimeoutException, NoSuchAlgorithmException
    {
        LOGGER.info("starting");
        final SessionParameters sessionParameters = new SessionParameters();
        sessionParameters.setTranslateHaphazardly(false);
        sessionParameters.setGenerateAudio(true);
        sessionParameters.session(Bends.class);

        if (sessionParameters.isTranslateHaphazardly())
        {
            final DeepLXClient deepLXClient = new DeepLXClient();
            final String test = deepLXClient.translate("Тест");
            if (!"Test".equals(test))
            {
                final String errMsg = "DeepLX returned unexpected result";
                LOGGER.error(errMsg);
                throw new RuntimeException(errMsg);
            }
        }

        createDirectories(Paths.get(CACHE));
        final Path dir = Paths.get(sessionParameters.session()
                                                    .getSimpleName() + "_" + now().toString()
                                                                                  .replace(":", "_"));


        sessionParameters.workingDir(dir);

        final ShellExecutor shellExecutor = new ShellExecutor(sessionParameters);

        final Processor processor = new Processor(sessionParameters,
                                                  new ToFileSaver(sessionParameters,
                                                                  shellExecutor,
                                                                  new VoiceProvider(new YandexSpeechSynthesisAPI(
                                                                          sessionParameters),
                                                                                    new Cache(sessionParameters))),
                                                  shellExecutor,
                                                  new Translator());

        LOGGER.info("executing processor");
        processor.process();

        logStats(sessionParameters);
        shutDownGobblerExecutor(sessionParameters);
    }

    private static void logStats(SessionParameters sessionParameters)
    {
        LOGGER.info("Yandex API hits: {}", sessionParameters.getYandexApiHits());
        LOGGER.info("Cache hits: {}", sessionParameters.getCacheHits());
        LOGGER.info("Yandex API retries: {}", sessionParameters.getYandexApiRetries());
        LOGGER.info("Skipped by chance: {}", sessionParameters.getSkippedByChance());

        LOGGER.info("total: {} | ru: {} ({}%) | en: {} ({}%) | de: {} ({}%)",
                    sessionParameters.getTotalLines(),
                    sessionParameters.getRuLines(),
                    (int) (sessionParameters.getRuLines() / (double) sessionParameters.getTotalLines() * 100),
                    sessionParameters.getEnLines(),
                    (int) (sessionParameters.getEnLines() / (double) sessionParameters.getTotalLines() * 100),
                    sessionParameters.getDeLines(),
                    (int) (sessionParameters.getDeLines() / (double) sessionParameters.getTotalLines() * 100));
    }

    private static void shutDownGobblerExecutor(final SessionParameters sessionParameters)
    {
        final ExecutorService executorService = sessionParameters.getStreamGobblerPool();
        executorService.shutdown();
        try
        {
            if (!executorService.awaitTermination(15, SECONDS))
            {
                executorService.shutdownNow();
            }
        }
        catch (final InterruptedException e)
        {
            LOGGER.error("gobbler shutdown error", e);
            executorService.shutdownNow();
        }
    }
}
