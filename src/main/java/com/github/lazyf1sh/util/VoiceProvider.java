package com.github.lazyf1sh.util;

import com.github.lazyf1sh.yandex.speech.api.Voice;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import static com.github.lazyf1sh.yandex.speech.api.YandexSpeechSynthesisAPI.yandexSpeechGenerate;

public class VoiceProvider {


    private final static Cache CACHE = new Cache();

    public byte[] get(final String text, Voice voice) throws NoSuchAlgorithmException, IOException, InterruptedException {
        Optional<byte[]> speech = CACHE.get(text, voice);
        if(speech.isPresent())
        {
            return speech.get();
        }
        else
        {
            byte[] generatedSpeech = yandexSpeechGenerate(text, voice);
            CACHE.overwrite(text, voice, generatedSpeech);
            return generatedSpeech;
        }

    }
}
