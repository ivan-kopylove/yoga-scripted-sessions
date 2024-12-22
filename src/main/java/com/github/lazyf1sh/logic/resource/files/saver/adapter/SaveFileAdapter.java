package com.github.lazyf1sh.logic.resource.files.saver.adapter;


import com.github.lazyf1sh.logic.resource.files.saver.api.SaveFileApi;
import com.github.lazyf1sh.logic.resource.files.saver.spi.SaveFileSpi;

public class SaveFileAdapter implements SaveFileSpi {

    private final SaveFileApi saveFileApi;

    public SaveFileAdapter(SaveFileApi saveFileApi) {

        this.saveFileApi = saveFileApi;
    }

    @Override
    public void saveFile(Payload myPayload) {
        saveFileApi.saveFile(new SaveFileApi.Payload(myPayload.filename(), myPayload.content(), myPayload.directory()));
    }


}
