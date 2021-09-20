package com.github.lazyf1sh.asanas.urdhvaHastasana;

import com.github.lazyf1sh.util.YogaConfig;

import java.io.IOException;
import java.nio.file.Paths;

import static com.github.lazyf1sh.util.Util.readFile;

public class UrdhvaHastasana {

    private static final String SANSKRIT_MEANING_PLACEHOLDER = "{{urdhva-hastasana-sanskrit-meaning}}";
    private static final String MEANING_PATH = "asanas/urdhva-hastasana/urdhva-hastasana-sanskrit-meaning-%s.txt";
    private static final String ON_HEELS_PATH = "asanas/urdhva-hastasana/urdhva-hastasana-on-heels.txt";
    private static final String ON_TIPTOES_PATH = "asanas/urdhva-hastasana/urdhva-hastasana-on-tiptoes";


    private final YogaConfig yogaConfig;

    public UrdhvaHastasana(final YogaConfig yogaConfig) {
        this.yogaConfig = yogaConfig;
    }

    public String build() throws IOException {

        String text = readFile(ON_HEELS_PATH);

        if (yogaConfig.isSanscritMeaning()) {
            final String meaningPath = String.format(MEANING_PATH, yogaConfig.getLanguage());
            final String meaning = readFile(meaningPath);
            text = text.replace(SANSKRIT_MEANING_PLACEHOLDER, meaning);
        } else {
            text = text.replace(SANSKRIT_MEANING_PLACEHOLDER, "");
        }
        return text;
    }

    public String urdhvaHastasanaOnTiptoes() throws IOException {
        return readFile(Paths.get(ON_TIPTOES_PATH), yogaConfig.getLanguage());
    }

}
