package com.github.lazyf1sh.asanas;

import com.github.lazyf1sh.YogaConfig;

import java.io.IOException;

import static com.github.lazyf1sh.Util.readFile;

public class UrdhvaHastasana {
    private static final String SANSKRIT_MEANING_PLACEHOLDER = "{{urdhva-hastasana-sanskrit-meaning}}";
    private static final String MEANING_PATH = "urdhva-hastasana/urdhva-hastasana-sanskrit-meaning-%s.txt";
    private final YogaConfig yogaConfig;

    public UrdhvaHastasana(YogaConfig yogaConfig) {
        this.yogaConfig = yogaConfig;
    }

    public String buildUrdhvaHastasana() throws IOException {
        String text = readFile("urdhva-hastasana/urdhva-hastasana-on-heels.txt");

        if (yogaConfig.isSanscritMeaning()) {
            String meaningPath = String.format(MEANING_PATH, yogaConfig.getLanguage());
            String meaning = readFile(meaningPath);
            text = text.replace(SANSKRIT_MEANING_PLACEHOLDER, meaning);
        } else {
            text = text.replace(SANSKRIT_MEANING_PLACEHOLDER, "");
        }
        return text;
    }
}
