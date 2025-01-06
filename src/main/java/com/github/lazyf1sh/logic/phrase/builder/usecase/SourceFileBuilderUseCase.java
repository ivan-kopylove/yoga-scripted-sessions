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

    private final BuildCurrentDateLineSpi dateBuilder;
    private final CommonBeginningConfigurationExecutorSpi commonBegin;
    private final ReadResourceApi resourceApi;
    private final SessionParameters parameters;


    public SourceFileBuilderUseCase(BuildCurrentDateLineSpi dateBuilder, CommonBeginningConfigurationExecutorSpi commonBeginningConfigurationExecutorSpi, ReadResourceApi resourceApi, SessionParameters parameters) {
        this.dateBuilder = dateBuilder;
        this.commonBegin = commonBeginningConfigurationExecutorSpi;
        this.resourceApi = resourceApi;
        this.parameters = parameters;
    }

    @Override
    public Result build() {

        try {
            List<SourceFile> result = new ArrayList<>();

            result.add(dateBuilder.callMe());
            result.addAll(commonBegin.build());

            List<Class<?>> sourceFileList;

            Suite suite = parameters.session()
                    .getDeclaredConstructor()
                    .newInstance();
            sourceFileList = suite.build();

            Objects.requireNonNull(sourceFileList);

            List<SourceFile> list = sourceFileList.stream()
                    .map(resourceApi::readResource)
                    .toList();

            result.addAll(list);
            result.add(resourceApi.readResource(Outro.class));

            return new Result.SuccessResult(result);
        } catch (IOException
                 | InvocationTargetException
                 | InstantiationException
                 | IllegalAccessException
                 | NoSuchMethodException e) {
            LOGGER.error("error", e);
            throw new RuntimeException(e);
        }
    }
}
