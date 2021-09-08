package com.github.lazyf1sh.asanas;

import com.github.lazyf1sh.suits.YogaSessionTextBuilder;
import com.github.lazyf1sh.util.YogaConfig;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.github.lazyf1sh.util.Util.readFile;

public class Bitilasana extends YogaSessionTextBuilder {

    private boolean pronounceSanskritName = true;
    private boolean pronounceRussianName = true;
    private final YogaConfig yogaConfig;

    public Bitilasana(final YogaConfig yogaConfig, final Path path) {
        super(yogaConfig, path);
        this.yogaConfig = yogaConfig;
    }

    public static Bitilasana bitilasana(final YogaConfig yogaConfig) {
        return new Bitilasana(yogaConfig, Paths.get("asanas/bitilasana/bitilasana-payload"));
    }

    public Bitilasana skipRussianName() {
        this.pronounceRussianName = false;
        return this;
    }

    public Bitilasana skipSanskritName() {
        this.pronounceSanskritName = false;
        return this;
    }


    @Override
    public String build() throws IOException {
        String text = super.build();
        if (pronounceRussianName) {
            final String russianName = readFile(Paths.get("asanas/bitilasana/bitilasana-russian-name"), yogaConfig.getLanguage());
            text = text.replace("{{bitilasana-russian-name}}", russianName);
        } else {
            text = text.replace("{{bitilasana-russian-name}}", "");
        }
        if (pronounceSanskritName) {
            final String sanskritName = readFile(Paths.get("asanas/bitilasana/bitilasana-sanskrit-name"), yogaConfig.getLanguage());
            text = text.replace("{{bitilasana-sanskrit-name}}", sanskritName);
        } else {
            text = text.replace("{{bitilasana-sanskrit-name}}", "");
        }
        return text;
    }
}
