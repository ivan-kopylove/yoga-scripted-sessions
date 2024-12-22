package com.github.lazyf1sh.logic.voice.adapter;


import com.github.ivan.kopylove.commons.client.yandex.api.speech.Voice;
import com.github.lazyf1sh.logic.voice.api.RandomRuVoicePickerApi;
import com.github.lazyf1sh.logic.voice.spi.RandomRuVoicePickerSpi;

public class RandomRuVoicePickerAdapter implements RandomRuVoicePickerSpi, RandomRuVoicePickerApi.Result.ResultAdapter<Voice> {

    private final RandomRuVoicePickerApi ruVoicePickerApi;

    public RandomRuVoicePickerAdapter(RandomRuVoicePickerApi ruVoicePickerApi) {

        this.ruVoicePickerApi = ruVoicePickerApi;
    }

    @Override
    public Voice randomRuVoice() {
        RandomRuVoicePickerApi.Result wrappedResult = ruVoicePickerApi.randomRuVoice();

        Voice result = wrappedResult.adapt(this);

        return result;
    }

    @Override
    public Voice onSuccess(RandomRuVoicePickerApi.Result.MySuccessResult result) {
        return result.myResultField();
    }


}
