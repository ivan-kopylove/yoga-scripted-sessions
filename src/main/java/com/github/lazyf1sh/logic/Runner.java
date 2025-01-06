package com.github.lazyf1sh.logic;

import com.github.ivan.kopylove.commons.ShellExecutor;
import com.github.ivan.kopylove.commons.ShellExecutorParameters;
import com.github.ivan.kopylove.commons.client.yandex.api.YandexApiJwtClient;
import com.github.ivan.kopylove.commons.client.yandex.api.speech.YandexApiParameters;
import com.github.ivan.kopylove.commons.client.yandex.api.speech.YandexSpeechSynthesisAPI;
import com.github.ivan.kopylove.commons.util.JWTTokenBuilder;
import com.github.lazyf1sh.asanas.named.*;
import com.github.lazyf1sh.asanas.named.hipsOpening.*;
import com.github.lazyf1sh.domain.*;
import com.github.lazyf1sh.logic.phrase.builder.adapter.*;
import com.github.lazyf1sh.logic.phrase.builder.api.*;
import com.github.lazyf1sh.logic.phrase.builder.usecase.*;
import com.github.lazyf1sh.logic.phrase.common.adapter.CommonBeginningConfigurationExecutorAdapter;
import com.github.lazyf1sh.logic.phrase.common.usecase.CommonBeginningConfigurationExecutorUseCase;
import com.github.lazyf1sh.logic.phrase.date.current.adapter.BuildCurrentDateLineAdapter;
import com.github.lazyf1sh.logic.phrase.date.current.usecase.BuildCurrentDateLineUseCase;
import com.github.lazyf1sh.logic.resource.files.ReadResourceUseCase;
import com.github.lazyf1sh.logic.resource.files.saver.adapter.SaveFileAdapter;
import com.github.lazyf1sh.logic.resource.files.saver.usecase.SaveFileUseCase;
import com.github.lazyf1sh.logic.resource.reader.json.adapter.AsanaResourceReadJsonResourceAdapter;
import com.github.lazyf1sh.logic.resource.reader.json.api.*;
import com.github.lazyf1sh.logic.resource.reader.json.usecase.JsonReaderUseCase;
import com.github.lazyf1sh.logic.serialization.adapter.SerializeToObjectAdapter;
import com.github.lazyf1sh.logic.voice.randomVoice.adapter.RandomRuVoicePickerAdapter;
import com.github.lazyf1sh.logic.voice.randomVoice.linePicker.adapter.RegularTextToAudioFileAdapter;
import com.github.lazyf1sh.logic.voice.randomVoice.linePicker.usecase.RegularTextToAudioFileUseCase;
import com.github.lazyf1sh.logic.voice.randomVoice.usecase.RandomRuVoicePickerUseCase;
import static java.nio.file.Files.newBufferedReader;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import static com.github.lazyf1sh.logic.Cache.CACHE;
import static com.github.lazyf1sh.logic.YandexApiEnvironmentVariable.*;
import static java.nio.file.Files.createDirectories;
import static java.time.Instant.now;

public final class Runner {
    private static final Logger LOGGER = LoggerFactory.getLogger(Runner.class);
    private static final String USER_HOME = System.getProperty("user.home");

    private Runner() {
    }

    public static void main(String[] args) throws IOException {
        LOGGER.info("starting");
        createDirectories(Paths.get(CACHE));

        stat();

        String folderId = System.getenv(YC_API_FOLDER_ID.name());
        String iamToken = buildIamToken();

        Processor processor = buildDependencies(folderId, iamToken);
        processor.process();

    }

    private static void stat() {
        SessionParameters parameters = new SessionParameters();
        List<SourceFile> result = new ArrayList<>();

        SerializeToObjectAdapter deserializer = new SerializeToObjectAdapter();
        JsonReaderUseCase jsonReaderApi = new JsonReaderUseCase(deserializer);
        AsanaResourceReadJsonResourceAdapter readJsonResourceSpi = new AsanaResourceReadJsonResourceAdapter(jsonReaderApi);
        ReadResourceUseCase resourceApi = new ReadResourceUseCase(readJsonResourceSpi);
        SourceFileBuilderUseCase dummy = new SourceFileBuilderUseCase(() -> new SourceFile("dummy", List.of()), List::of, resourceApi, parameters);

        List<Class<? extends Suite>> classes = List.of(Bends.class, HipsOpening.class, SuryaNamaskar.class);
        classes.forEach(abc -> {
                    parameters.session(Bends.class);
                    SourceFileBuilderApi.Result build = dummy.build();
                    result.addAll(build.adapt(SourceFileBuilderApi.Result.SuccessResult::myResultField));
                }
        );

        result.get(0);
    }

    private static Processor buildDependencies(String ycApiFolderId, String iamToken1) {
        String iamToken = iamToken1;

        SessionParameters sessionParameters = new SessionParameters();
        sessionParameters.session(HipsOpening.class);
        Path dir = Paths.get(sessionParameters.session().getSimpleName() + "_" + now().toString().replace(":", "_"));
        sessionParameters.workingDir(dir);

        YandexApiParameters apiParameters = new YandexApiParameters(ycApiFolderId, iamToken);
        ShellExecutorParameters shellExecutorParameters = new ShellExecutorParameters(dir);
        ShellExecutor shellExecutor = new ShellExecutor(shellExecutorParameters);

        Cache cache = new Cache(sessionParameters);
        RandomRuVoicePickerAdapter randomRuVoicePickerAdapter = new RandomRuVoicePickerAdapter(new RandomRuVoicePickerUseCase());
        YandexSpeechSynthesisAPI yandexSpeechSynthesisAPI = new YandexSpeechSynthesisAPI(apiParameters);
        VoiceProvider voiceProvider = new VoiceProvider(yandexSpeechSynthesisAPI, cache);
        SaveFileAdapter saveFileAdapter = new SaveFileAdapter(new SaveFileUseCase());
        RegularTextToAudioFileAdapter regularTextToAudioFileAdapter = new RegularTextToAudioFileAdapter(new RegularTextToAudioFileUseCase(voiceProvider, saveFileAdapter, randomRuVoicePickerAdapter, sessionParameters));

        ToFileSaver toFileSaver = new ToFileSaver(sessionParameters, shellExecutor, regularTextToAudioFileAdapter);

        BuildCurrentDateLineUseCase buildCurrentDateLineUseCase = new BuildCurrentDateLineUseCase();
        BuildCurrentDateLineAdapter buildCurrentDateLineSpi = new BuildCurrentDateLineAdapter(buildCurrentDateLineUseCase);
        ReadResourceUseCase readResourceApi = new ReadResourceUseCase(new AsanaResourceReadJsonResourceAdapter(new JsonReaderUseCase(new SerializeToObjectAdapter())));
        CommonBeginningConfigurationExecutorUseCase commonBeginningConfigurationUseCase = new CommonBeginningConfigurationExecutorUseCase(readResourceApi);
        CommonBeginningConfigurationExecutorAdapter commonBeginningConfigurationAdapter = new CommonBeginningConfigurationExecutorAdapter(commonBeginningConfigurationUseCase);
        SourceFileBuilderAdapter sourceFileBuilderAdapter = new SourceFileBuilderAdapter(new SourceFileBuilderUseCase(buildCurrentDateLineSpi, commonBeginningConfigurationAdapter, readResourceApi, sessionParameters));
        Processor processor = new Processor(sessionParameters, toFileSaver, shellExecutor, sourceFileBuilderAdapter, shellExecutorParameters);
        return processor;
    }

    private static String buildIamToken() {
        String serviceAccountId = System.getenv(YANDEX_CLOUD_SERVICE_ACCOUNT_ID.name());
        String keyId = System.getenv(YANDEX_CLOUD_AUTHORIZED_KEY_ID.name());
        Path of = Path.of(USER_HOME, YC_API_AUTHORIZED_KEY);

        JWTTokenBuilder jwtTokenBuilder = new JWTTokenBuilder();
        String encodedToken = jwtTokenBuilder.buildJwtToken(serviceAccountId, keyId, of, YC_IAM_TOKEN_SOURCE);

        YandexApiJwtClient yandexApiJwtClient = new YandexApiJwtClient();
        String iamToken = yandexApiJwtClient.requestIamToken(encodedToken);
        return iamToken;
    }


}
