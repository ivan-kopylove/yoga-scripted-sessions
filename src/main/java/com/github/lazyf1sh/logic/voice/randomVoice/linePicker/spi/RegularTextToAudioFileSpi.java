package com.github.lazyf1sh.logic.voice.randomVoice.linePicker.spi;


import com.github.lazyf1sh.domain.Line;

@FunctionalInterface
public interface RegularTextToAudioFileSpi {

    void save(Payload myPayload);


    record Payload(Line line, int rollingFileName) {
    }

}
