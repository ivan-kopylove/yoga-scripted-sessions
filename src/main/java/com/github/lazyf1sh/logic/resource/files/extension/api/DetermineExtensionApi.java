package com.github.lazyf1sh.logic.resource.files.extension.api;

import com.github.lazyf1sh.logic.resource.files.extension.ResourceExtension;

@FunctionalInterface
public interface DetermineExtensionApi {
    Result callMe(Payload payload);

    record Payload(Class<?> clazz){}

    interface Result {

        <T> T adapt(ResultAdapter<T> resultAdapter);

        interface ResultAdapter<T> {
            T onSuccess(MySuccessResult result);
        }

        record MySuccessResult(ResourceExtension extension) implements Result {

            @Override
            public <T> T adapt(ResultAdapter<T> resultAdapter) {
                return resultAdapter.onSuccess(this);
            }
        }

    }
}
