package com.github.lazyf1sh.logic.phrase.builder.usecase;


import com.github.lazyf1sh.asanas.named.outro.*;
import com.github.lazyf1sh.domain.*;
import com.github.lazyf1sh.logic.phrase.builder.api.*;
import com.github.lazyf1sh.logic.phrase.common.spi.*;
import com.github.lazyf1sh.logic.phrase.date.current.spi.*;
import com.github.lazyf1sh.logic.resource.files.*;
import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import org.slf4j.*;

public class SourceFileBuilderUseCase implements SourceFileBuilderApi {


    private static final Logger LOGGER = LoggerFactory.getLogger(SourceFileBuilderUseCase.class);

    private final BuildCurrentDateLineSpi buildCurrentDateLineSpi;
    private final CommonBeginningConfigurationExecutorSpi commonBeginningConfigurationExecutorSpi;
    private final ReadResourceApi readResourceApi;
    private final SessionParameters sessionParameters;


    public SourceFileBuilderUseCase(BuildCurrentDateLineSpi buildCurrentDateLineSpi, CommonBeginningConfigurationExecutorSpi commonBeginningConfigurationExecutorSpi, ReadResourceApi readResourceApi, SessionParameters sessionParameters) {
        this.buildCurrentDateLineSpi = buildCurrentDateLineSpi;
        this.commonBeginningConfigurationExecutorSpi = commonBeginningConfigurationExecutorSpi;
        this.readResourceApi = readResourceApi;
        this.sessionParameters = sessionParameters;
    }

    @Override
    public Result build() {

        try {
            List<SourceFile> result = new ArrayList<>();

            result.add(buildCurrentDateLineSpi.callMe());
            result.addAll(commonBeginningConfigurationExecutorSpi.build());

            List<Class<?>> sourceFileList;
            try {
                Suite suite = sessionParameters.session()
                        .getDeclaredConstructor()
                        .newInstance();
                sourceFileList = suite.build();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                LOGGER.error("session instantiation error", e);
                throw new RuntimeException(e);
            }
            Objects.requireNonNull(sourceFileList);

            List<SourceFile> list = sourceFileList.stream()
                    .map(readResourceApi::readResource)
                    .toList();

            result.addAll(list);
            result.add(readResourceApi.readResource(Outro.class));

            return new Result.SuccessResult(result);
        } catch (IOException e) {
            LOGGER.error("error", e);
            throw new RuntimeException(e);
        }
    }
}
