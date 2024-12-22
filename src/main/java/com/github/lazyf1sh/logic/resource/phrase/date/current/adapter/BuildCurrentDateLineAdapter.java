package com.github.lazyf1sh.logic.resource.phrase.date.current.adapter;


import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.logic.resource.phrase.date.current.api.BuildCurrentDateLineApi;
import com.github.lazyf1sh.logic.resource.phrase.date.current.spi.BuildCurrentDateLineSpi;

public class BuildCurrentDateLineAdapter implements BuildCurrentDateLineSpi, BuildCurrentDateLineApi.Result.ResultAdapter<SourceFile> {

    private final BuildCurrentDateLineApi myApi;

    public BuildCurrentDateLineAdapter(BuildCurrentDateLineApi myApi) {

        this.myApi = myApi;
    }

    @Override
    public SourceFile callMe() {
        BuildCurrentDateLineApi.Result wrappedResult = myApi.buildCurrentDate();

        SourceFile result = wrappedResult.adapt(this);

        return result;
    }

    @Override
    public SourceFile onSuccess(BuildCurrentDateLineApi.Result.Success result) {
        return result.myResultField();
    }
}
