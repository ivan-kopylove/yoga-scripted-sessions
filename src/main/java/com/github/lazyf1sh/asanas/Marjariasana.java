package com.github.lazyf1sh.asanas;

import com.github.lazyf1sh.suits.YogaSessionTextBuilder;
import com.github.lazyf1sh.util.YogaConfig;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.github.lazyf1sh.util.Util.readAsana;
import static com.github.lazyf1sh.util.Util.readFile;

public class Marjariasana extends YogaSessionTextBuilder {

    private boolean pronounceSanskritName = true;
    private boolean pronounceRussianName = true;
    private final YogaConfig yogaConfig;

    public Marjariasana(final YogaConfig yogaConfig, final Path path) {
        super(yogaConfig, path);
        this.yogaConfig = yogaConfig;
    }

    public Marjariasana skipRussianName() {
        this.pronounceRussianName = false;
        return this;
    }

    public Marjariasana skipSanskritName() {
        this.pronounceSanskritName = false;
        return this;
    }

    public static Marjariasana marjariasana(final YogaConfig yogaConfig) {
        return new Marjariasana(yogaConfig, Paths.get("asanas/marjariasana/marjariasana-payload"));
    }

    public String kneeToForeHead() throws IOException {
        return readAsana(Paths.get("marjariasana/marjariasana-knee-to-forehead-payload"), yogaConfig.getLanguage(), yogaConfig.getSide());
    }

    @Override
    public String build() throws IOException {
        String text = super.build();
        if (pronounceRussianName) {
            final String russianName = readFile(Paths.get("asanas/marjariasana/marjariasana-russian-name"), yogaConfig.getLanguage());
            text = text.replace("{{marjariasana-russian-name}}", russianName);
        } else {
            text = text.replace("{{marjariasana-russian-name}}", "");
        }
        if (pronounceSanskritName) {
            final String sanskritName = readFile(Paths.get("asanas/marjariasana/marjariasana-sanskrit-name"), yogaConfig.getLanguage());
            text = text.replace("{{marjariasana-sanskrit-name}}", sanskritName);
        } else {
            text = text.replace("{{marjariasana-sanskrit-name}}", "");
        }
        return text;
    }
}
