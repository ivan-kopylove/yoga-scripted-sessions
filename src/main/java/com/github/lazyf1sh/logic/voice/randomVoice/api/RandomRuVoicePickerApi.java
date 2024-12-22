package com.github.lazyf1sh.logic.voice.randomVoice.api;

import com.github.ivan.kopylove.commons.client.yandex.api.speech.Voice;

@FunctionalInterface
public interface RandomRuVoicePickerApi {
    Result randomRuVoice();



    interface Result {

        <T> T adapt(ResultAdapter<T> resultAdapter);

        interface ResultAdapter<T> {

            T onSuccess(MySuccessResult result);


        }

        record MySuccessResult(Voice myResultField) implements Result {

            @Override
            public <T> T adapt(ResultAdapter<T> resultAdapter) {
                return resultAdapter.onSuccess(this);
            }
        }


    }
}
