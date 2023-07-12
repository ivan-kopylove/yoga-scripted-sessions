package com.github.lazyf1sh.util;

import com.github.lazyf1sh.domain.Voice;
import com.github.lazyf1sh.yandex.speech.api.YandexSpeechSynthesisAPI;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

public class VoiceProvider
{

    private final Cache                    cache;
    private final YandexSpeechSynthesisAPI yandexSpeechSynthesisAPI;

    public VoiceProvider(final YandexSpeechSynthesisAPI yandexSpeechSynthesisAPI, final Cache cache)
    {

        this.yandexSpeechSynthesisAPI = yandexSpeechSynthesisAPI;
        this.cache = cache;
    }

    public byte[] get(final String text, final Voice voice) throws NoSuchAlgorithmException, IOException, InterruptedException
    {
        final Optional<byte[]> speech = cache.get(text, voice);
        if (speech.isPresent())
        {
            return speech.get();
        }
        else
        {
            final byte[] generatedSpeech = yandexSpeechSynthesisAPI.yandexSpeechGenerate(text, voice);
            cache.overwrite(text, voice, generatedSpeech);
            return generatedSpeech;
        }
    }
}
