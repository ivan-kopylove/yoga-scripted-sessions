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
import com.github.lazyf1sh.logic.phrase.common.api.CommonBeginningConfigurationApi;
import com.github.lazyf1sh.logic.phrase.common.api.CommonBeginningConfigurationApi.Result.Success;
import com.github.lazyf1sh.logic.resource.files.ReadResourceApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommonBeginningConfigurationUseCase implements CommonBeginningConfigurationApi {


    private final ReadResourceApi readResourceApi;

    public CommonBeginningConfigurationUseCase(ReadResourceApi readResourceApi) {
        this.readResourceApi = readResourceApi;
    }

    @Override
    public Result build() {

        try {
            List<SourceFile> result = new ArrayList<>();

            result.add(new SourceFile(List.of(new Line("sil<[40000]>"))));

            List<SourceFile> list = Stream.of(
                            Disclaimer.class,
                            Requisite.class,
                            Nails.class,
                            TotalAbs.class,
                            VibroGymnastics.class,
                            TibetanHormonalGymnastics.class,
                            CommonWarmup.class
                    )
                    .map(readResourceApi::read).toList();

            result.addAll(list);

            return new Success(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
