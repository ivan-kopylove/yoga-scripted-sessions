package com.github.lazyf1sh.logic;

import com.github.ivan.kopylove.commons.client.yandex.api.speech.YandexApiParameters;
import com.github.ivan.kopylove.commons.client.yandex.api.speech.YandexSpeechSynthesisAPI;
import com.github.ivan.kopylove.commons.util.JWTTokenBuilder;
import com.github.lazyf1sh.api.YandexApiJwtClient;
import com.github.lazyf1sh.asanas.named.Bends;
import com.github.lazyf1sh.domain.SessionParameters;
import com.github.lazyf1sh.logic.resource.phrase.date.current.adapter.BuildCurrentDateLineAdapter;
import com.github.lazyf1sh.logic.resource.phrase.date.current.usecase.BuildCurrentDateLineUseCase;
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
import static com.github.lazyf1sh.logic.YandexApiEnvironmentVariable.*;
import static java.nio.file.Files.createDirectories;
import static java.time.Instant.now;
import static java.util.concurrent.TimeUnit.SECONDS;

public final class Runner {
    private static final Logger LOGGER = LoggerFactory.getLogger(Runner.class);
    private static final String USER_HOME = System.getProperty("user.home");

    private Runner() {
    }

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException, TimeoutException, NoSuchAlgorithmException {
        LOGGER.info("starting");

        String ycApiFolderId = System.getenv(YC_API_FOLDER_ID.name());
        String serviceAccountId = System.getenv(YANDEX_CLOUD_SERVICE_ACCOUNT_ID.name());
        String keyId = System.getenv(YANDEX_CLOUD_AUTHORIZED_KEY_ID.name());
        Path of = Path.of(USER_HOME, YC_API_AUTHORIZED_KEY);

        JWTTokenBuilder jwtTokenBuilder = new JWTTokenBuilder();
        String encodedToken = jwtTokenBuilder.buildJwtToken(serviceAccountId, keyId, of, YC_IAM_TOKEN_SOURCE);

        YandexApiJwtClient yandexApiJwtClient = new YandexApiJwtClient();
        String iamToken = yandexApiJwtClient.requestIamToken(encodedToken);

        SessionParameters sessionParameters = new SessionParameters();
        sessionParameters.setGenerateAudio(true);
        sessionParameters.session(Bends.class);
        createDirectories(Paths.get(CACHE));
        Path dir = Paths.get(sessionParameters.session().getSimpleName() + "_" + now().toString().replace(":", "_"));
        sessionParameters.workingDir(dir);

        YandexApiParameters apiParameters = new YandexApiParameters(ycApiFolderId, iamToken);
        ShellExecutor shellExecutor = new ShellExecutor(sessionParameters);

        Cache cache = new Cache(sessionParameters);
        YandexSpeechSynthesisAPI yandexSpeechSynthesisAPI = new YandexSpeechSynthesisAPI(apiParameters);
        VoiceProvider voiceProvider = new VoiceProvider(yandexSpeechSynthesisAPI, cache);
        ToFileSaver toFileSaver = new ToFileSaver(sessionParameters, shellExecutor, voiceProvider);
        BuildCurrentDateLineUseCase buildCurrentDateLineUseCase = new BuildCurrentDateLineUseCase();
        BuildCurrentDateLineAdapter buildCurrentDateLineSpi = new BuildCurrentDateLineAdapter(buildCurrentDateLineUseCase);
        Processor processor = new Processor(sessionParameters, toFileSaver, shellExecutor, buildCurrentDateLineSpi);

        LOGGER.info("executing processor");
        processor.process();

        logStats(sessionParameters);
        shutDownGobblerExecutor(sessionParameters);
    }

    private static void logStats(SessionParameters sessionParameters) {
        LOGGER.info("Cache hits: {}", sessionParameters.getCacheHits());
        LOGGER.info("Skipped by chance: {}", sessionParameters.getSkippedByChance());

        LOGGER.info("total: {} | ru: {} ({}%) | en: {} ({}%)", sessionParameters.getTotalLines(), sessionParameters.getRuLines(), (int) (sessionParameters.getRuLines() / (double) sessionParameters.getTotalLines() * 100), sessionParameters.getEnLines(), (int) (sessionParameters.getEnLines() / (double) sessionParameters.getTotalLines() * 100));
    }

    private static void shutDownGobblerExecutor(SessionParameters sessionParameters) {
        ExecutorService executorService = sessionParameters.getStreamGobblerPool();
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(15, SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            LOGGER.error("gobbler shutdown error", e);
            executorService.shutdownNow();
        }
    }
}
