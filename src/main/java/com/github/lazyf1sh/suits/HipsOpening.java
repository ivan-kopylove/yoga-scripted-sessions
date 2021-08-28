package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.asanas.UrdhvaHastasana;
import com.github.lazyf1sh.transitions.Transitionad96a996f0ca;
import com.github.lazyf1sh.util.YogaConfig;

import java.io.IOException;

import static com.github.lazyf1sh.util.Util.readFile;

public class HipsOpening {

    private final YogaConfig yogaConfig;

    public HipsOpening(final YogaConfig yogaConfig) {
        this.yogaConfig = yogaConfig;
    }

    public String buildHipsOpeningSession() throws IOException {
        final StringBuilder result = new StringBuilder();
        result.append(new Warmup(yogaConfig).build());
        result.append(new UrdhvaHastasana(yogaConfig).urdhvaHastasanaOnTiptoes());
        result.append(readFile("f2238bca3e1b.txt"));
        result.append(new Transitionad96a996f0ca().build());
        result.append(getHipsOpeningBody());
        result.append(new Outro().build());
        return result.toString();
    }

    private static String getHipsOpeningBody() throws IOException {
        return readFile("hips-opening-body.txt");
    }
}
