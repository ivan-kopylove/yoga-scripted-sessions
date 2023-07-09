package com.github.lazyf1sh.yandex.speech.api;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public enum Voice
{
    JOHN, LEA, ERMIL, PHILIP, ALENA, MADIRUS, ZAHAR, OMAZH, JANE, PREVIOUS;

    public static Voice randomRuVoice()
    {
        List<Voice> ruVoices = List.of(ERMIL, PHILIP, ALENA, MADIRUS, ZAHAR, OMAZH, JANE);
        int i = ThreadLocalRandom.current().nextInt(0, ruVoices.size());
        return ruVoices.get(i);
    }

}
