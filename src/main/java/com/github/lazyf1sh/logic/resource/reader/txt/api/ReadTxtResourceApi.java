package com.github.lazyf1sh.logic.resource.reader.txt.api;

import com.github.lazyf1sh.domain.SourceFile;

@FunctionalInterface
public interface ReadTxtResourceApi {
    Result readTxt(Payload myPayload);

    record Payload(Class<?> clazz) {
    }

    interface Result {

        <T> T adapt(ResultAdapter<T> resultAdapter);

        interface ResultAdapter<T> {

            T onSuccess(MySuccessResult result);

        }

        record MySuccessResult(SourceFile sourceFile) implements Result {

            @Override
            public <T> T adapt(ResultAdapter<T> resultAdapter) {
                return resultAdapter.onSuccess(this);
            }
        }

    }
}
