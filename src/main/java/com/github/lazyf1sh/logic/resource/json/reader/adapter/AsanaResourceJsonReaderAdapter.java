package com.github.lazyf1sh.logic.resource.json.reader.adapter;


import com.github.lazyf1sh.logic.resource.json.reader.api.JsonReaderApi;
import com.github.lazyf1sh.logic.resource.json.reader.api.JsonReaderApi.Result.ResultAdapter;
import com.github.lazyf1sh.logic.resource.json.reader.spi.JsonReaderSpi;

public class AsanaResourceJsonReaderAdapter implements JsonReaderSpi, ResultAdapter<String> {

    private final JsonReaderApi jsonReaderApi;

    public AsanaResourceJsonReaderAdapter(JsonReaderApi jsonReaderApi) {
        this.jsonReaderApi = jsonReaderApi;
    }

    @Override
    public String readJsonAsanaResouce(Payload myPayload) {
        JsonReaderApi.Result wrappedResult = jsonReaderApi.readJsonAsanaResouce(new JsonReaderApi.Payload(myPayload.myPayload()));

        String result = wrappedResult.adapt(this);

        return result;
    }


    @Override
    public String onSuccess(JsonReaderApi.Result.MySuccessResult result) {
        return "";
    }
}
