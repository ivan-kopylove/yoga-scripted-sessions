package com.github.lazyf1sh.yandex.speech.api;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Collections.unmodifiableList;

public enum Voice
{
    JOHN, LEA, ERMIL, PHILIP, ALENA, MADIRUS, ZAHAR, OMAZH, JANE, PREVIOUS;

    public static final List<Voice> RU_VOICES = unmodifiableList(List.of(ERMIL, PHILIP, ALENA, MADIRUS, ZAHAR, OMAZH, JANE));
    private static final List<Voice> RU_VOICE_RANDOM_POOL = new ArrayList<>();
    private static final ThreadLocalRandom THREAD_LOCAL_RANDOM = ThreadLocalRandom.current();

    public static Voice randomRuVoice()
    {
        if (RU_VOICE_RANDOM_POOL.size() < 1)
        {
            RU_VOICE_RANDOM_POOL.addAll(RU_VOICES);
        }

        int pos = THREAD_LOCAL_RANDOM.nextInt(0, RU_VOICE_RANDOM_POOL.size());
        Voice voice = RU_VOICE_RANDOM_POOL.get(pos);
        RU_VOICE_RANDOM_POOL.remove(pos);
        return voice;
    }
}
