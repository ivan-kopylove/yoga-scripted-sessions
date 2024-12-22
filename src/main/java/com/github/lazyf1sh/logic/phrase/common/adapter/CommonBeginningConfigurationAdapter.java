package com.github.lazyf1sh.logic.phrase.common.adapter;


import com.github.lazyf1sh.logic.phrase.common.api.CommonBeginningConfigurationApi;
import com.github.lazyf1sh.logic.phrase.common.spi.CommonBeginningConfigurationSpi;

public class CommonBeginningConfigurationAdapter implements CommonBeginningConfigurationSpi, CommonBeginningConfigurationApi.Result.ResultAdapter<String> {

    private final CommonBeginningConfigurationApi myApi;

    public CommonBeginningConfigurationAdapter(CommonBeginningConfigurationApi myApi) {

        this.myApi = myApi;
    }

    @Override
    public String callMe(Payload myPayload) {
        CommonBeginningConfigurationApi.Result wrappedResult = myApi.callMe(new CommonBeginningConfigurationApi.Payload(myPayload.myPayload()));

        String result = wrappedResult.adapt(this);

        return result;
    }

    @Override
    public String onSuccess(CommonBeginningConfigurationApi.Result.MySuccessResult result) {
        return result.myResultField();
    }

}
