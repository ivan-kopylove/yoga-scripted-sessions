package com.github.lazyf1sh.logic.voice.randomVoice.usecase;


import com.github.ivan.kopylove.commons.client.yandex.api.speech.Voice;
import com.github.lazyf1sh.logic.voice.randomVoice.api.RandomRuVoicePickerApi;

import java.util.concurrent.ThreadLocalRandom;

public class RandomRuVoicePickerUseCase implements RandomRuVoicePickerApi {
    private Integer voiceLines = getVoiceLines();
    private Voice ruMainVoice = Voice.randomRuVoice();

    @Override
    public Result randomRuVoice() {
        if (voiceLines < 1) {
            voiceLines = getVoiceLines();
            ruMainVoice = Voice.randomRuVoice();
        }

        voiceLines--;

        return new Result.MySuccessResult(ruMainVoice);
    }

    private static int getVoiceLines() {
        return ThreadLocalRandom.current().nextInt(10, 30);
    }
}
