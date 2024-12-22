package com.github.lazyf1sh.logic.resource.reader.txt.adapter;


import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.logic.resource.reader.txt.api.ReadTxtResourceApi;
import com.github.lazyf1sh.logic.resource.reader.txt.spi.ReadTxtResourceSpi;

public class ReadTxtResourceAdapter implements ReadTxtResourceSpi, ReadTxtResourceApi.Result.ResultAdapter<SourceFile> {

    private final ReadTxtResourceApi myApi;

    public ReadTxtResourceAdapter(ReadTxtResourceApi myApi) {

        this.myApi = myApi;
    }


    @Override
    public SourceFile onSuccess(ReadTxtResourceApi.Result.MySuccessResult result) {
        return result.sourceFile();
    }

    @Override
    public SourceFile readTxt(Payload myPayload) {
        ReadTxtResourceApi.Result wrappedResult = myApi.readTxt(new ReadTxtResourceApi.Payload(myPayload.myPayload()));

        SourceFile result = wrappedResult.adapt(this);

        return result;
    }
}
