package com.github.lazyf1sh.asanas.ardhaUttanasana;

import com.github.lazyf1sh.util.YogaConfig;

import java.io.IOException;

import static com.github.lazyf1sh.util.Util.readFile;

public class ArdhaUttanasana {

    private final YogaConfig yogaConfig;

    public ArdhaUttanasana(final YogaConfig yogaConfig) {
        this.yogaConfig = yogaConfig;
    }

    public String build() throws IOException {
        return readFile("asanas/ardha-uttanasana/ardha-uttanasana-payload", yogaConfig.getLanguage());
    }
}
