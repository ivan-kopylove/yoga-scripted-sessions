package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.transitions.Unnamed_f2238bca3e1b;
import com.github.lazyf1sh.util.YogaConfig;

import java.io.IOException;
import java.nio.file.Paths;

import static com.github.lazyf1sh.asanas.HastaUttanasana.hastaUttanasana;
import static com.github.lazyf1sh.transitions.GenericTransition.genericTransition;

public class LegSplit {

    private YogaConfig yogaConfig;

    public LegSplit(YogaConfig yogaConfig) {
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
}
