package com.github.lazyf1sh.logic.phrase.builder.api;

import com.github.lazyf1sh.domain.*;
import java.util.*;

@FunctionalInterface
public interface SourceFileBuilderApi {
    Result build();

    record Payload(String myPayload) {
    }

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
