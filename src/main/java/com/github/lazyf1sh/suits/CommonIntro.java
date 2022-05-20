package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.asanas.balasana.Balasana;
import com.github.lazyf1sh.asanas.tadasana.Tadasana;
import com.github.lazyf1sh.transitions.Transition_3ebc07c8470b;
import com.github.lazyf1sh.transitions.Unnamed_7d8c46afd699;
import com.github.lazyf1sh.util.YogaConfig;

import java.io.IOException;
import java.nio.file.Paths;

import static com.github.lazyf1sh.asanas.bitilasana.Bitilasana.bitilasana;
import static com.github.lazyf1sh.asanas.marjariasana.Marjariasana.marjariasana;
import static com.github.lazyf1sh.util.Util.readFile;

public class CommonIntro {

    private final YogaConfig yogaConfig;

    public CommonIntro(final YogaConfig yogaConfig) {
        this.yogaConfig = yogaConfig;
    }

    public String build() throws IOException {
        final StringBuilder warmup = new StringBuilder();

        warmup.append("Старт.\n");
        warmup.append("sil <[20000]>\n");
        warmup.append(new Requisite(yogaConfig).build());
        warmup.append(new Tadasana(yogaConfig).palmsInNamaste());
        warmup.append(new Unnamed_7d8c46afd699(yogaConfig).build());
        warmup.append(new Balasana(yogaConfig).build());
        warmup.append(new Transition_3ebc07c8470b(yogaConfig).build());
        warmup.append(bitilasana(yogaConfig).build());
        warmup.append(marjariasana(yogaConfig).build());
        warmup.append(bitilasana(yogaConfig).skipRussianName().skipSanskritName().build());
        warmup.append(marjariasana(yogaConfig).build());
        warmup.append(marjariasana(yogaConfig).kneeToForeHead());

        warmup.append(readFile(Paths.get("common-intro"), yogaConfig.getLanguage())).append("\n");

        return warmup.toString();
    }
}
