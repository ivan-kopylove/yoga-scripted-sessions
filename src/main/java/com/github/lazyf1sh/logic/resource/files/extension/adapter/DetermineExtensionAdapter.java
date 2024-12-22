package com.github.lazyf1sh.logic.resource.files.extension.adapter;


import com.github.lazyf1sh.logic.resource.files.extension.ResourceExtension;
import com.github.lazyf1sh.logic.resource.files.extension.api.DetermineExtensionApi;
import com.github.lazyf1sh.logic.resource.files.extension.spi.DetermineExtensionSpi;

public class DetermineExtensionAdapter implements DetermineExtensionSpi, DetermineExtensionApi.Result.ResultAdapter<ResourceExtension> {

    private final DetermineExtensionApi myApi;

    public DetermineExtensionAdapter(DetermineExtensionApi myApi) {

        this.myApi = myApi;
    }

    @Override
    public ResourceExtension callMe(Payload myPayload) {
        DetermineExtensionApi.Result wrappedResult = myApi.getExtension(new DetermineExtensionApi.Payload(myPayload.myPayload()));

        ResourceExtension result = wrappedResult.adapt(this);

        return result;
    }

    @Override
    public ResourceExtension onSuccess(DetermineExtensionApi.Result.MySuccessResult result) {
        return result.extension();
    }
}
