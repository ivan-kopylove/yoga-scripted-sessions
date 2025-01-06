package com.github.lazyf1sh.logic.phrase.builder.adapter;


import com.github.lazyf1sh.domain.*;
import com.github.lazyf1sh.logic.phrase.builder.api.SourceFileBuilderApi;
import com.github.lazyf1sh.logic.phrase.builder.spi.*;
import java.util.*;

public class SourceFileBuilderAdapter implements SourceFileBuilderSpi, SourceFileBuilderApi.Result.ResultAdapter<List<SourceFile>> {

    private final SourceFileBuilderApi myApi;

    public SourceFileBuilderAdapter(SourceFileBuilderApi myApi) {

        this.myApi = myApi;
    }

    @Override
    public List<SourceFile> build() {
        SourceFileBuilderApi.Result wrappedResult = myApi.build();

        List<SourceFile> result = wrappedResult.adapt(this);

        return result;
    }

    @Override
    public List<SourceFile> onSuccess(SourceFileBuilderApi.Result.MySuccessResult result) {
        return result.myResultField();
    }

}
