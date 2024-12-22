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
import com.github.lazyf1sh.logic.phrase.common.api.CommonBeginningConfigurationApi.Result.MySuccessResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CommonBeginningConfigurationUseCase implements CommonBeginningConfigurationApi {


    @Override
    public Result build() {

        try {
            List<SourceFile> result = new ArrayList<>();

            result.add(new SourceFile(List.of(new Line("sil<[40000]>"))));
            result.add(new Disclaimer().build());
            result.add(new Requisite().build());
            result.addAll(new Nails().build());
            result.addAll(new TotalAbs().build());
            result.addAll(new VibroGymnastics().build());
            result.addAll(new TibetanHormonalGymnastics().build());
            result.addAll(new CommonWarmup().build());

            return new MySuccessResult(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
