package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.asanas.ArdhaUttanasana;
import com.github.lazyf1sh.asanas.UrdhvaHastasana;
import com.github.lazyf1sh.transitions.Unnamed_d6054818ad4b;
import com.github.lazyf1sh.transitions.Unnamed_f2238bca3e1b;
import com.github.lazyf1sh.util.YogaConfig;

import java.io.IOException;

import static com.github.lazyf1sh.util.Util.readFile;

public class Bends {

    private final YogaConfig yogaConfig;

    public Bends(final YogaConfig yogaConfig) {
        this.yogaConfig = yogaConfig;
    }

    public String build() throws IOException {
        final StringBuilder result = new StringBuilder();

        result.append(new Warmup(yogaConfig).build());

        result.append(new UrdhvaHastasana(yogaConfig).urdhvaHastasanaOnTiptoes());
        result.append(new Unnamed_f2238bca3e1b(yogaConfig).build());
        result.append(new Unnamed_d6054818ad4b(yogaConfig).build());
        result.append(new ArdhaUttanasana(yogaConfig).build());


        result.append(getBendsBody());
        result.append(new Outro().build());

        return result.toString();
    }

    private static String getBendsBody() throws IOException {
        return readFile("bends-body.txt");
    }
}
