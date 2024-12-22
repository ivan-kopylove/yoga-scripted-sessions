package com.github.lazyf1sh.logic.voice.randomVoice.linePicker.api;

import com.github.lazyf1sh.domain.Line;

@FunctionalInterface
public interface RegularTextToAudioFileApi {
    void save(Payload myPayload);

    record Payload(Line line, int rollingFileName) {
    }


}
