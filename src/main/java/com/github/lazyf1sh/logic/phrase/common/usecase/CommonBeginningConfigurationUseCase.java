package com.github.lazyf1sh.logic.phrase.common.usecase;


import com.github.lazyf1sh.logic.phrase.common.api.CommonBeginningConfigurationApi;
import com.github.lazyf1sh.logic.phrase.common.api.CommonBeginningConfigurationApi.Result.MySuccessResult;

public class CommonBeginningConfigurationUseCase implements CommonBeginningConfigurationApi {


    @Override
    public Result callMe(Payload myPayload) {
        return new MySuccessResult("");
    }
}
