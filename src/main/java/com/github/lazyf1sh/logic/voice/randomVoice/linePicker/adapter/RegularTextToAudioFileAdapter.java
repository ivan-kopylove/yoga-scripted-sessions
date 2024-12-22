package com.github.lazyf1sh.logic.voice.randomVoice.linePicker.adapter;


import com.github.lazyf1sh.logic.voice.randomVoice.linePicker.api.RegularTextToAudioFileApi;
import com.github.lazyf1sh.logic.voice.randomVoice.linePicker.spi.RegularTextToAudioFileSpi;

public class RegularTextToAudioFileAdapter implements RegularTextToAudioFileSpi {

    private final RegularTextToAudioFileApi lineApi;

    public RegularTextToAudioFileAdapter(RegularTextToAudioFileApi lineApi) {

        this.lineApi = lineApi;
    }

    @Override
    public void save(Payload myPayload) {
        lineApi.save(new RegularTextToAudioFileApi.Payload(myPayload.line(), myPayload.rollingFileName()));

    }

}
