package com.github.lazyf1sh.yandex.speech.api;

import com.github.lazyf1sh.domain.Voice;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.github.lazyf1sh.domain.Language.RU;
import static com.github.lazyf1sh.domain.Voice.randomRuVoice;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class VoiceTest
{

    @Test
    public void run()
    {
        for (int k = 0; k < 10000000; k++)
        {
            Set<Voice> voiceSet = new HashSet<>();
            Set<Voice> voices = List.of(Voice.values())
                                    .stream()
                                    .filter(v -> v.getLanguage() == RU)
                                    .collect(Collectors.toSet());

            for (int i = 0; i < voices.size(); i++)
            {
                Voice voice = randomRuVoice();
                voiceSet.add(voice);
            }

            assertThat(voiceSet.size(), equalTo(voices.size()));
            assertThat(voiceSet, equalTo(voices));
        }
    }
}