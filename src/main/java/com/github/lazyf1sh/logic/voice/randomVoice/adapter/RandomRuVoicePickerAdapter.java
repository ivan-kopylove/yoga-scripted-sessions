package com.github.lazyf1sh.logic.voice.randomVoice.adapter;


import com.github.ivan.kopylove.commons.client.yandex.api.speech.Voice;
import com.github.lazyf1sh.logic.voice.randomVoice.api.RandomRuVoicePickerApi;
import com.github.lazyf1sh.logic.voice.randomVoice.spi.RandomRuVoicePickerSpi;

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
