package com.github.lazyf1sh.asanas.bitilasana;

import com.github.lazyf1sh.suits.YogaSessionTextBuilder;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.github.lazyf1sh.util.Util.readFile;

public class Bitilasana extends YogaSessionTextBuilder {

    private boolean pronounceSanskritName = true;
    private boolean pronounceRussianName = true;
    

    public Bitilasana(final Path path) {
        super(path);
        
    }

    public static Bitilasana bitilasana() {
        return new Bitilasana(Paths.get("asanas/bitilasana/bitilasana-payload"));
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
            final String russianName = readFile(Paths.get("asanas/bitilasana/bitilasana-russian-name"), "ru");
            text = text.replace("{{bitilasana-russian-name}}", russianName);
        } else {
            text = text.replace("{{bitilasana-russian-name}}", "");
        }
        if (pronounceSanskritName) {
            final String sanskritName = readFile(Paths.get("asanas/bitilasana/bitilasana-sanskrit-name"), "ru");
            text = text.replace("{{bitilasana-sanskrit-name}}", sanskritName);
        } else {
            text = text.replace("{{bitilasana-sanskrit-name}}", "");
        }
        return text;
    }
}
