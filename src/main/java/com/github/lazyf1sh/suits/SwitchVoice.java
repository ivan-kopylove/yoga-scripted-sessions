package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.domain.Line;
import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.nodes.Asana;
import com.github.lazyf1sh.yandex.speech.api.Voice;

import java.io.IOException;
import java.util.List;

public class SwitchVoice extends Asana {


    public static SourceFile switchVoice(Voice voice) throws IOException {
        Line line = new Line(String.format("{\"switchRuMainVoice\":\"%s\"}", voice.name()));

        return new SourceFile(null, List.of(line));
    }
}
