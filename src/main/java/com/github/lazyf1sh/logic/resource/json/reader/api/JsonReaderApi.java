package com.github.lazyf1sh.logic.resource.json.reader.api;

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

        record MySuccessResult(String myResultField) implements Result {

            @Override
            public <T> T adapt(ResultAdapter<T> resultAdapter) {
                return resultAdapter.onSuccess(this);
            }
        }



    }
}
