package com.github.lazyf1sh.asanas;

import com.github.lazyf1sh.microtype.FileName;
import com.github.lazyf1sh.util.YogaConfig;

import java.io.IOException;

import static com.github.lazyf1sh.util.Util.readFile;

public class Dhanurasana extends Asana {

    private final YogaConfig yogaConfig;

    public Dhanurasana(final YogaConfig yogaConfig) {
        super(yogaConfig, new FileName("asanas/dhanurasana/dhanurasana-payload"));
        this.yogaConfig = yogaConfig;
    }

    public String dandayamana() throws IOException {
        String result = readFile("asanas/dhanurasana/danayamana-dhanurasana-payload", yogaConfig.getLanguage());

        if (yogaConfig.isSanscritMeaning()) {
            String dandaMeaning = readFile("interpretations/danda", yogaConfig.getLanguage());
            String yamanaMeaning = readFile("interpretations/yamana", yogaConfig.getLanguage());
            String dhanuMeaning = readFile("interpretations/dhanu", yogaConfig.getLanguage());

            StringBuilder meaningBuilder = new StringBuilder();
            meaningBuilder.append(dandaMeaning).append(" ");
            meaningBuilder.append(yamanaMeaning).append(" ");
            meaningBuilder.append(dhanuMeaning).append(" ");

            result = result.replace("{{danayamana-dhanurasana-meaning}}", meaningBuilder);
        }


        return result;
    }
}
