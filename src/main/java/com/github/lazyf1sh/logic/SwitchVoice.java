package com.github.lazyf1sh.logic;

import com.github.lazyf1sh.asanas.Asana;
import com.github.lazyf1sh.domain.Line;
import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.domain.Voice;

import java.io.IOException;
import java.util.List;

public class SwitchVoice extends Asana
{

    public static SourceFile switchVoice(final Voice voice) throws IOException
    {
        final Line line = new Line(String.format("{\"switchRuMainVoice\":\"%s\"}", voice.name()));

        return new SourceFile(null, List.of(line));
    }

    public static SourceFile randomRuVoice() throws IOException
    {
        return SwitchVoice.switchVoice(Voice.randomRuVoice());
    }
}
