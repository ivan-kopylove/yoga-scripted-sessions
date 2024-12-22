package com.github.lazyf1sh.logic.phrase.common.adapter;


import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.logic.phrase.common.api.CommonBeginningConfigurationApi;
import com.github.lazyf1sh.logic.phrase.common.spi.CommonBeginningConfigurationSpi;

import java.util.List;

public class CommonBeginningConfigurationAdapter implements CommonBeginningConfigurationSpi, CommonBeginningConfigurationApi.Result.ResultAdapter<List<SourceFile>> {

    private final CommonBeginningConfigurationApi myApi;

    public CommonBeginningConfigurationAdapter(CommonBeginningConfigurationApi myApi) {

        this.myApi = myApi;
    }

    @Override
    public List<SourceFile> build() {
        CommonBeginningConfigurationApi.Result wrappedResult = myApi.build();

        List<SourceFile> result = wrappedResult.adapt(this);

        return result;
    }

    @Override
    public List<SourceFile> onSuccess(CommonBeginningConfigurationApi.Result.MySuccessResult result) {
        return result.myResultField();
    }

}
