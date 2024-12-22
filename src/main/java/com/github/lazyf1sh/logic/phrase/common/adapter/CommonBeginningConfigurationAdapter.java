package com.github.lazyf1sh.logic.phrase.common.adapter;


import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.logic.phrase.common.api.CommonBeginningConfigurationExecutorApi;
import com.github.lazyf1sh.logic.phrase.common.spi.CommonBeginningConfigurationSpi;

import java.util.List;

public class CommonBeginningConfigurationAdapter implements CommonBeginningConfigurationSpi, CommonBeginningConfigurationExecutorApi.Result.ResultAdapter<List<SourceFile>> {

    private final CommonBeginningConfigurationExecutorApi commonBeginningConfigurationExecutorApi;

    public CommonBeginningConfigurationAdapter(CommonBeginningConfigurationExecutorApi commonBeginningConfigurationExecutorApi) {

        this.commonBeginningConfigurationExecutorApi = commonBeginningConfigurationExecutorApi;
    }

    @Override
    public List<SourceFile> build() {
        CommonBeginningConfigurationExecutorApi.Result wrappedResult = commonBeginningConfigurationExecutorApi.build();

        List<SourceFile> result = wrappedResult.adapt(this);

        return result;
    }

    @Override
    public List<SourceFile> onSuccess(CommonBeginningConfigurationExecutorApi.Result.Success result) {
        return result.commonLines();
    }

}
