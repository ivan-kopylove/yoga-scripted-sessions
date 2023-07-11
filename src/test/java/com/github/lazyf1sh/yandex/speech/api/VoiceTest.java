package com.github.lazyf1sh.yandex.speech.api;

import com.github.lazyf1sh.domain.Voice;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static com.github.lazyf1sh.domain.Voice.RU_VOICES;
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
            for (int i = 0; i < RU_VOICES.size(); i++)
            {
                Voice voice = randomRuVoice();
                voiceSet.add(voice);
            }

            assertThat(voiceSet.size(), equalTo(RU_VOICES.size()));
        }
    }
}