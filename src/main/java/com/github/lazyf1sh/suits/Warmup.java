package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.asanas.Tadasana;
import com.github.lazyf1sh.util.YogaConfig;

import java.io.IOException;
import java.nio.file.Paths;

import static com.github.lazyf1sh.util.Util.readFile;

public class Warmup {

    private final YogaConfig yogaConfig;

    public Warmup(final YogaConfig yogaConfig) {
        this.yogaConfig = yogaConfig;
    }

    public String build() throws IOException {
        final StringBuilder warmup = new StringBuilder();

        warmup.append(new Disclaimer(yogaConfig).build());
        warmup.append(new Requisite(yogaConfig).build());
        warmup.append(new Tadasana(yogaConfig).palmsInNamaste());

        warmup.append(readFile(Paths.get("common-intro"), yogaConfig.getLanguage())).append("\n");

        return warmup.toString();
    }
}
