package com.github.lazyf1sh.logic.phrase.common.api;

@FunctionalInterface
public interface CommonBeginningConfigurationApi {
    Result callMe(Payload myPayload);

    record Payload(String myPayload) {
    }

    interface Result {

        <T> T adapt(ResultAdapter<T> resultAdapter);

        interface ResultAdapter<T> {

            T onSuccess(MySuccessResult result);

        }

        record MySuccessResult(String myResultField) implements Result {

            @Override
            public <T> T adapt(ResultAdapter<T> resultAdapter) {
                return resultAdapter.onSuccess(this);
            }
        }

    }
}
