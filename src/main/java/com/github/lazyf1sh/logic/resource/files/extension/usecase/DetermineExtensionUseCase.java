package com.github.lazyf1sh.logic.resource.files.extension.usecase;

import com.github.lazyf1sh.logic.resource.files.extension.api.DetermineExtensionApi;
import com.github.lazyf1sh.logic.resource.files.extension.api.DetermineExtensionApi.Result.MySuccessResult;

import java.net.URL;

import static com.github.lazyf1sh.logic.resource.files.extension.ResourceExtension.JSON;
import static com.github.lazyf1sh.logic.resource.files.extension.ResourceExtension.TXT;
import static com.github.lazyf1sh.util.Util.JSON_EXTENSION;
import static com.github.lazyf1sh.util.Util.TXT_EXTENSION;

public class DetermineExtensionUseCase implements DetermineExtensionApi {

    @Override
    public Result callMe(DetermineExtensionApi.Payload payload) {
        Class<?> clazz = payload.clazz();
        String name = clazz.getSimpleName();

        URL txt = clazz.getResource(name + TXT_EXTENSION);
        URL json = clazz.getResource(name + JSON_EXTENSION);

        if (json != null) {
            return new MySuccessResult(JSON);
        }
        if (txt != null) {
            return new MySuccessResult(TXT);
        }

        throw new RuntimeException("unsupported");
    }
}
