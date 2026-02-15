package com.github.lazyf1sh.logic;

import com.github.ivan.kopylove.commons.CmdShellExecutor;
import com.github.ivan.kopylove.commons.ShellExecutorParameters;
import com.github.ivan.kopylove.commons.client.yandex.api.YandexApiJwtClient;
import com.github.ivan.kopylove.commons.client.yandex.api.speech.YandexApiParameters;
import com.github.ivan.kopylove.commons.client.yandex.api.speech.YandexSpeechSynthesisAPI;
import com.github.ivan.kopylove.commons.util.JWTTokenBuilder;
import com.github.lazyf1sh.asanas.named.Bends;
import com.github.lazyf1sh.asanas.named.SuryaNamaskar;
import com.github.lazyf1sh.asanas.named.hipsOpening.HipsOpening;
import com.github.lazyf1sh.domain.LineLanguage;
import com.github.lazyf1sh.domain.SessionParameters;
import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.domain.Suite;
import com.github.lazyf1sh.logic.phrase.builder.adapter.SourceFileBuilderAdapter;
import com.github.lazyf1sh.logic.phrase.builder.api.SourceFileBuilderApi;
import com.github.lazyf1sh.logic.phrase.builder.usecase.SourceFileBuilderUseCase;
import com.github.lazyf1sh.logic.phrase.common.adapter.CommonBeginningConfigurationExecutorAdapter;
import com.github.lazyf1sh.logic.phrase.common.usecase.CommonBeginningConfigurationExecutorUseCase;
import com.github.lazyf1sh.logic.phrase.date.current.adapter.BuildCurrentDateLineAdapter;
import com.github.lazyf1sh.logic.phrase.date.current.usecase.BuildCurrentDateLineUseCase;
import com.github.lazyf1sh.logic.resource.files.ReadResourceUseCase;
import com.github.lazyf1sh.logic.resource.files.saver.adapter.SaveFileAdapter;
import com.github.lazyf1sh.logic.resource.files.saver.usecase.SaveFileUseCase;
import com.github.lazyf1sh.logic.resource.reader.json.adapter.AsanaResourceReadJsonResourceAdapter;
import com.github.lazyf1sh.logic.resource.reader.json.usecase.JsonReaderUseCase;
import com.github.lazyf1sh.logic.serialization.adapter.SerializeToObjectAdapter;
import com.github.lazyf1sh.logic.voice.randomVoice.adapter.RandomRuVoicePickerAdapter;
import com.github.lazyf1sh.logic.voice.randomVoice.linePicker.adapter.RegularTextToAudioFileAdapter;
import com.github.lazyf1sh.logic.voice.randomVoice.linePicker.usecase.RegularTextToAudioFileUseCase;
import com.github.lazyf1sh.logic.voice.randomVoice.usecase.RandomRuVoicePickerUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.github.ivan.kopylove.commons.client.yandex.api.speech.Language.RU;
import static com.github.lazyf1sh.logic.Cache.CACHE;
import static com.github.lazyf1sh.logic.YandexApiEnvironmentVariable.YANDEX_CLOUD_AUTHORIZED_KEY_ID;
import static com.github.lazyf1sh.logic.YandexApiEnvironmentVariable.YANDEX_CLOUD_SERVICE_ACCOUNT_ID;
import static com.github.lazyf1sh.logic.YandexApiEnvironmentVariable.YC_API_AUTHORIZED_KEY;
import static com.github.lazyf1sh.logic.YandexApiEnvironmentVariable.YC_API_FOLDER_ID;
import static com.github.lazyf1sh.logic.YandexApiEnvironmentVariable.YC_IAM_TOKEN_SOURCE;
import static java.time.Instant.now;

public final class MainRunner
{
    private static final Logger LOGGER    = LoggerFactory.getLogger(MainRunner.class);
    private static final String USER_HOME = System.getProperty("user.home");

    private MainRunner()
    {
    }

    public static void main(String[] args) throws IOException
    {
        LOGGER.info("starting");
        Files.createDirectories(Paths.get(CACHE));

        SessionParameters sessionParameters = new SessionParameters();
        sessionParameters.setSession(SuryaNamaskar.class);
        sessionParameters.setLanguage(LineLanguage.RU);
        sessionParameters.setPauseMultiplier(1.1);
        Path dir = Paths.get(sessionParameters.setSession().getSimpleName() + "_" + now().toString().replace(":", "_"));
        sessionParameters.getWorkingDir(dir);

        stat(sessionParameters);

        String folderId = System.getenv(YC_API_FOLDER_ID.name());
        String iamToken = buildIamToken();

        Processor processor = buildDependencies(folderId, iamToken, sessionParameters);

        processor.process();
    }

    private static void stat(SessionParameters parameters)
    {
        List<SourceFile> result = new ArrayList<>();

        SerializeToObjectAdapter deserializer = new SerializeToObjectAdapter();
        JsonReaderUseCase jsonReaderApi = new JsonReaderUseCase(deserializer);
        AsanaResourceReadJsonResourceAdapter readJsonResourceSpi = new AsanaResourceReadJsonResourceAdapter(jsonReaderApi);
        ReadResourceUseCase resourceApi = new ReadResourceUseCase(readJsonResourceSpi);
        SourceFileBuilderUseCase dummy = new SourceFileBuilderUseCase(() -> new SourceFile("dummy", List.of()),
                List::of,
                resourceApi,
                parameters);

        List<Class<? extends Suite>> classes = List.of(Bends.class, HipsOpening.class, SuryaNamaskar.class);
        classes.forEach(abc -> {
                    parameters.setSession(abc);
                    SourceFileBuilderApi.Result build = dummy.build();
                    result.addAll(build.adapt(SourceFileBuilderApi.Result.SuccessResult::sourceFiles));
                }
        );

        result.get(0);
    }

    private static Processor buildDependencies(String ycApiFolderId, String iamToken1, SessionParameters sessionParameters)
    {
        String iamToken = iamToken1;



        YandexApiParameters apiParameters = new YandexApiParameters(ycApiFolderId, iamToken);
        ShellExecutorParameters shellExecutorParameters = new ShellExecutorParameters(sessionParameters.getWorkingDir());
        CmdShellExecutor shellExecutor = new CmdShellExecutor(shellExecutorParameters);

        Cache cache = new Cache(sessionParameters);
        RandomRuVoicePickerAdapter randomRuVoicePickerAdapter = new RandomRuVoicePickerAdapter(new RandomRuVoicePickerUseCase());
        YandexSpeechSynthesisAPI yandexSpeechSynthesisAPI = new YandexSpeechSynthesisAPI(apiParameters);
        VoiceProvider voiceProvider = new VoiceProvider(yandexSpeechSynthesisAPI, cache);
        SaveFileAdapter saveFileAdapter = new SaveFileAdapter(new SaveFileUseCase());
        RegularTextToAudioFileAdapter regularTextToAudioFileAdapter = new RegularTextToAudioFileAdapter(new RegularTextToAudioFileUseCase(
                voiceProvider,
                saveFileAdapter,
                randomRuVoicePickerAdapter,
                sessionParameters));

        ToFileSaver toFileSaver = new ToFileSaver(sessionParameters, shellExecutor, regularTextToAudioFileAdapter);

        BuildCurrentDateLineUseCase buildCurrentDateLineUseCase = new BuildCurrentDateLineUseCase();
        BuildCurrentDateLineAdapter buildCurrentDateLineSpi = new BuildCurrentDateLineAdapter(buildCurrentDateLineUseCase);
        ReadResourceUseCase readResourceApi = new ReadResourceUseCase(new AsanaResourceReadJsonResourceAdapter(new JsonReaderUseCase(new SerializeToObjectAdapter())));
        CommonBeginningConfigurationExecutorUseCase commonBeginningConfigurationUseCase = new CommonBeginningConfigurationExecutorUseCase(
                readResourceApi);
        CommonBeginningConfigurationExecutorAdapter commonBeginningConfigurationAdapter = new CommonBeginningConfigurationExecutorAdapter(
                commonBeginningConfigurationUseCase);
        SourceFileBuilderAdapter sourceFileBuilderAdapter = new SourceFileBuilderAdapter(new SourceFileBuilderUseCase(
                buildCurrentDateLineSpi,
                commonBeginningConfigurationAdapter,
                readResourceApi,
                sessionParameters));
        Processor processor = new Processor(sessionParameters,
                toFileSaver,
                shellExecutor,
                sourceFileBuilderAdapter,
                shellExecutorParameters);
        return processor;
    }

    private static String buildIamToken()
    {
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
