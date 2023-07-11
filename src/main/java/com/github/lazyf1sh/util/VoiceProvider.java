package com.github.lazyf1sh.util;

import com.github.lazyf1sh.yandex.speech.api.Voice;
import com.github.lazyf1sh.yandex.speech.api.YandexSpeechSynthesisAPI;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

public class VoiceProvider
{


    private final Cache cache;
    private final YandexSpeechSynthesisAPI yandexSpeechSynthesisAPI;

    public VoiceProvider(YandexSpeechSynthesisAPI yandexSpeechSynthesisAPI, Cache cache)
    {

        this.yandexSpeechSynthesisAPI = yandexSpeechSynthesisAPI;
        this.cache = cache;
    }


    public byte[] get(final String text, Voice voice) throws NoSuchAlgorithmException, IOException, InterruptedException
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
