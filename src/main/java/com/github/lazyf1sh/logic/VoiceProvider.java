package com.github.lazyf1sh.logic;

import com.github.ivan.kopylove.commons.client.yandex.api.speech.Voice;
import com.github.ivan.kopylove.commons.client.yandex.api.speech.YandexSpeechSynthesisAPI;

import java.util.Optional;

public class VoiceProvider
{

    private final Cache                    cache;
    private final YandexSpeechSynthesisAPI yandexSpeechSynthesisAPI;

    public VoiceProvider(YandexSpeechSynthesisAPI yandexSpeechSynthesisAPI, Cache cache)
    {

        this.yandexSpeechSynthesisAPI = yandexSpeechSynthesisAPI;
        this.cache = cache;
    }

    public byte[] get(String text, Voice voice)
    {
        Optional<byte[]> speech = cache.get(text, voice);
        if (speech.isPresent())
        {
            return speech.get();
        }
        else
        {
            byte[] generatedSpeech = yandexSpeechSynthesisAPI.yandexSpeechGenerate(text, voice);
            cache.overwrite(text, voice, generatedSpeech);
            return generatedSpeech;
        }
    }
}
