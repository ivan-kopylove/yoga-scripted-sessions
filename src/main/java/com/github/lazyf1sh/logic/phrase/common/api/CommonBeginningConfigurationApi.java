package com.github.lazyf1sh.logic.phrase.common.api;

import com.github.lazyf1sh.domain.SourceFile;

import java.util.List;

@FunctionalInterface
public interface CommonBeginningConfigurationApi {
    Result build();


    interface Result {

        <T> T adapt(ResultAdapter<T> resultAdapter);

        interface ResultAdapter<T> {

            T onSuccess(MySuccessResult result);

        }

        record MySuccessResult(List<SourceFile> myResultField) implements Result {

            @Override
            public <T> T adapt(ResultAdapter<T> resultAdapter) {
                return resultAdapter.onSuccess(this);
            }
        }

    }
}
