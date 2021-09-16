package com.github.lazyf1sh.asanas;

import com.github.lazyf1sh.util.YogaConfig;

import java.io.IOException;

import static com.github.lazyf1sh.sides.TextReplacer.enrichSidePlaceHolder;
import static com.github.lazyf1sh.util.Util.readFile;

public class Makarasana {
    private final YogaConfig yogaConfig;

    public Makarasana(final YogaConfig yogaConfig) {
        this.yogaConfig = yogaConfig;
    }

    public String build() throws IOException {
        String makarasana = readFile("asanas/marakasana/makarasana-payload", yogaConfig.getLanguage());

        makarasana = enrichSidePlaceHolder(yogaConfig.getSide(), makarasana);


        if (yogaConfig.isSanscritMeaning()) {
            makarasana = makarasana.replace("{{makarasana-meaning}}", readFile("interpretations/makara", yogaConfig.getLanguage()));
        }

        return makarasana;
    }
}
