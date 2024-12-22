package com.github.lazyf1sh.logic.phrase.common.adapter;


import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.logic.phrase.common.api.CommonBeginningConfigurationExecutorApi;
import com.github.lazyf1sh.logic.phrase.common.spi.CommonBeginningConfigurationExecutorSpi;

import java.util.List;

public class CommonBeginningConfigurationExecutorAdapter implements CommonBeginningConfigurationExecutorSpi, CommonBeginningConfigurationExecutorApi.Result.ResultAdapter<List<SourceFile>> {

    private final CommonBeginningConfigurationExecutorApi commonBeginningConfigurationExecutorApi;

    public CommonBeginningConfigurationExecutorAdapter(CommonBeginningConfigurationExecutorApi commonBeginningConfigurationExecutorApi) {

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
