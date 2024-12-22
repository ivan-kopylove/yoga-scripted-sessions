package com.github.lazyf1sh.logic.resource.phrase.date.current.api;

import com.github.lazyf1sh.domain.SourceFile;

@FunctionalInterface
public interface BuildCurrentDateLineApi {
    Result buildCurrentDate();


    interface Result {

        record Success(SourceFile myResultField) implements Result {

            @Override
            public <T> T adapt(ResultAdapter<T> resultAdapter) {
                return resultAdapter.onSuccess(this);
            }
        }

        <T> T adapt(ResultAdapter<T> resultAdapter);

        interface ResultAdapter<T> {

            T onSuccess(Success result);


        }





    }
}
