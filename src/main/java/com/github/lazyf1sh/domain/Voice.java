package com.github.lazyf1sh.domain;

import java.util.ArrayList;
import java.util.List;

import static com.github.lazyf1sh.domain.Language.*;
import static com.github.lazyf1sh.domain.VoiceGender.*;
import static com.github.lazyf1sh.util.Util.shuffle;
import static java.util.stream.Collectors.toList;

public enum Voice
{
    JOHN(MALE, EN),
    LEA(FEMALE, DE),
    ERMIL(MALE, RU),
    PHILIP(MALE, RU),
    ALENA(FEMALE, RU),
    MADIRUS(MALE, RU),
    ZAHAR(MALE, RU),
    OMAZH(MALE, RU),
    JANE(FEMALE, RU),
    PREVIOUS(UNKNOWN_GENDER, UNKNOWN_LANG);

    private static final List<Voice> ALL_VOICES        = List.of(Voice.values());
    private static final List<Voice> VOICE_RANDOM_POOL = new ArrayList<>();
    private static       VoiceGender nextRandomGender  = MALE;
    private final        VoiceGender gender;
    private final        Language    language;

    public VoiceGender getGender()
    {
        return gender;
    }

    public Language getLanguage()
    {
        return language;
    }

    Voice(VoiceGender gender, Language language)
    {
        this.gender = gender;
        this.language = language;
    }

    public static Voice randomRuVoice()
    {
        if (VOICE_RANDOM_POOL.size() < 1)
        {
            List<Voice> ruVoices = ALL_VOICES.stream()
                                             .filter(voice -> voice.language == RU)
                                             .collect(toList());

            VOICE_RANDOM_POOL.addAll(ruVoices);
        }

        while (VOICE_RANDOM_POOL.size() > 0)
        {
            Voice voice;
            switch (nextRandomGender)
            {
                case MALE:
                    nextRandomGender = FEMALE;


                    voice = VOICE_RANDOM_POOL.stream()
                                             .filter(v -> v.gender == MALE)
                                             .filter(v -> v.language == RU)
                                             .min(shuffle())
                                             .orElseThrow();
                    if (voice == PREVIOUS)
                    {
                        continue;
                    }
                    break;
                case FEMALE:
                    nextRandomGender = MALE;

                    voice = VOICE_RANDOM_POOL.stream()
                                             .filter(v -> v.gender == FEMALE)
                                             .filter(v -> v.language == RU)
                                             .min(shuffle())
                                             .orElse(PREVIOUS);
                    if (voice == PREVIOUS)
                    {
                        continue;
                    }
                    break;
                default:
                    throw new RuntimeException("case is not handled");
            }

            VOICE_RANDOM_POOL.remove(voice);
            return voice;
        }

        throw new RuntimeException("case is not handled");
    }
}
