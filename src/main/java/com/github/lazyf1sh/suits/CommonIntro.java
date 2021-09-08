package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.asanas.Balasana;
import com.github.lazyf1sh.asanas.Tadasana;
import com.github.lazyf1sh.transitions.Unnamed_7d8c46afd699;
import com.github.lazyf1sh.util.YogaConfig;

import java.io.IOException;
import java.nio.file.Paths;

import static com.github.lazyf1sh.util.Util.readFile;

public class CommonIntro {

    private final YogaConfig yogaConfig;

    public CommonIntro(final YogaConfig yogaConfig) {
        this.yogaConfig = yogaConfig;
    }

    public String build() throws IOException {
        final StringBuilder warmup = new StringBuilder();

        warmup.append("sil <[5000]>");
        warmup.append(new Disclaimer(yogaConfig).build());
        warmup.append(new Requisite(yogaConfig).build());
        warmup.append(new Tadasana(yogaConfig).palmsInNamaste());
        warmup.append(new Unnamed_7d8c46afd699(yogaConfig).build());
        warmup.append(new Balasana(yogaConfig).build());
        warmup.append(readFile(Paths.get("common-intro"), yogaConfig.getLanguage())).append("\n");

        return warmup.toString();
    }
}
