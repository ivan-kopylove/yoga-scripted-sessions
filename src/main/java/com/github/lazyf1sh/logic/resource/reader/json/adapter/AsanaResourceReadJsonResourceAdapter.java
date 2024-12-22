package com.github.lazyf1sh.logic.resource.reader.json.adapter;


import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.logic.resource.reader.json.api.JsonReaderApi;
import com.github.lazyf1sh.logic.resource.reader.json.api.JsonReaderApi.Result.ResultAdapter;
import com.github.lazyf1sh.logic.resource.reader.json.spi.ReadJsonResourceSpi;

public class AsanaResourceReadJsonResourceAdapter implements ReadJsonResourceSpi, ResultAdapter<SourceFile> {

    private final JsonReaderApi jsonReaderApi;

    public AsanaResourceReadJsonResourceAdapter(JsonReaderApi jsonReaderApi) {
        this.jsonReaderApi = jsonReaderApi;
    }

    @Override
    public SourceFile readJsonAsanaResouce(Payload myPayload) {
        JsonReaderApi.Result wrappedResult = jsonReaderApi.readJsonAsanaResouce(new JsonReaderApi.Payload(myPayload.myPayload()));

        SourceFile result = wrappedResult.adapt(this);

        return result;
    }


    @Override
    public SourceFile onSuccess(JsonReaderApi.Result.MySuccessResult result) {
        return result.sources();
    }
}
