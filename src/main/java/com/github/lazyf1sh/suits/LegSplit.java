package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.transitions.Unnamed_f2238bca3e1b;
import com.github.lazyf1sh.util.YogaConfig;

import java.io.IOException;
import java.nio.file.Paths;

import static com.github.lazyf1sh.asanas.hastauttanasana.HastaUttanasana.hastaUttanasana;
import static com.github.lazyf1sh.transitions.GenericTransition.genericTransition;

public class LegSplit {

    private final YogaConfig yogaConfig;

    public LegSplit(final YogaConfig yogaConfig) {
        this.yogaConfig = yogaConfig;
    }

    public String build() throws IOException {
        final StringBuilder result = new StringBuilder();

        result.append(new CommonIntro(yogaConfig).build());
        result.append(new Unnamed_f2238bca3e1b(yogaConfig).build());
        result.append(genericTransition(yogaConfig, Paths.get("5d5160263051")));
        result.append(hastaUttanasana(yogaConfig));


        return result.toString();
    }

    public static String legSplitSession(final YogaConfig yogaConfig) throws IOException {
        return new LegSplit(yogaConfig).build();
    }
}