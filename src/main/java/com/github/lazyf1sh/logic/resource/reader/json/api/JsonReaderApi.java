package com.github.lazyf1sh.logic.resource.reader.json.api;

import com.github.lazyf1sh.domain.SourceFile;

@FunctionalInterface
public interface JsonReaderApi {
    Result readJsonAsanaResouce(Payload myPayload);

    record Payload(Class<?> myPayload) {
    }

    interface Result {

        <T> T adapt(ResultAdapter<T> resultAdapter);

        interface ResultAdapter<T> {

            T onSuccess(MySuccessResult result);

        }

        record MySuccessResult(SourceFile sources) implements Result {

            @Override
            public <T> T adapt(ResultAdapter<T> resultAdapter) {
                return resultAdapter.onSuccess(this);
            }
        }



    }
}
