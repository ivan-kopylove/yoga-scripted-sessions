package com.github.lazyf1sh.logic.phrase.common.adapter;


import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.logic.phrase.common.api.CommonBeginningConfigurationApi;
import com.github.lazyf1sh.logic.phrase.common.spi.CommonBeginningConfigurationSpi;

import java.util.List;

public class CommonBeginningConfigurationAdapter implements CommonBeginningConfigurationSpi, CommonBeginningConfigurationApi.Result.ResultAdapter<List<SourceFile>> {

    private final CommonBeginningConfigurationApi commonBeginningConfigurationApi;

    public CommonBeginningConfigurationAdapter(CommonBeginningConfigurationApi commonBeginningConfigurationApi) {

        this.commonBeginningConfigurationApi = commonBeginningConfigurationApi;
    }

    @Override
    public List<SourceFile> build() {
        CommonBeginningConfigurationApi.Result wrappedResult = commonBeginningConfigurationApi.build();

        List<SourceFile> result = wrappedResult.adapt(this);

        return result;
    }

    @Override
    public List<SourceFile> onSuccess(CommonBeginningConfigurationApi.Result.Success result) {
        return result.commonLines();
    }

}
