package com.github.lazyf1sh.logic.voice.randomVoice.spi;


import com.github.ivan.kopylove.commons.client.yandex.api.speech.Voice;

@FunctionalInterface
public interface RandomRuVoicePickerSpi {

    Voice randomRuVoice();



}
