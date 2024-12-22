package com.github.lazyf1sh.logic.phrase.common.usecase;


import com.github.lazyf1sh.asanas.named.commonWarump.CommonWarmup;
import com.github.lazyf1sh.asanas.named.disclaimer.Disclaimer;
import com.github.lazyf1sh.asanas.named.nails.Nails;
import com.github.lazyf1sh.asanas.named.requisite.Requisite;
import com.github.lazyf1sh.asanas.named.tibetanHormonalGymnastics.TibetanHormonalGymnastics;
import com.github.lazyf1sh.asanas.named.totalabs.TotalAbs;
import com.github.lazyf1sh.asanas.named.vibroGymnastics.VibroGymnastics;
import com.github.lazyf1sh.domain.Line;
import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.logic.phrase.common.api.CommonBeginningConfigurationExecutorApi;
import com.github.lazyf1sh.logic.phrase.common.api.CommonBeginningConfigurationExecutorApi.Result.Success;
import com.github.lazyf1sh.logic.resource.files.ReadResourceApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CommonBeginningConfigurationExecutorUseCase implements CommonBeginningConfigurationExecutorApi {


    private final ReadResourceApi readResourceApi;

    public CommonBeginningConfigurationExecutorUseCase(ReadResourceApi readResourceApi) {
        this.readResourceApi = readResourceApi;
    }

    @Override
    public Result build() {

        try {
            List<SourceFile> result = new ArrayList<>();

            result.add(new SourceFile("silence", List.of(new Line("""
                    { "silence": 40000 }"""))));

            List<SourceFile> list = Stream.of(
                            Disclaimer.class,
                            Requisite.class,
                            Nails.class,
                            TotalAbs.class,
                            VibroGymnastics.class,
                            TibetanHormonalGymnastics.class

                    )
                    .map(readResourceApi::readResource)
                    .toList();

            result.addAll(list);

            List<SourceFile> warmup = new CommonWarmup()
                    .build()
                    .stream()
                    .map(readResourceApi::readResource)
                    .toList();

            result.addAll(warmup);

            return new Success(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
