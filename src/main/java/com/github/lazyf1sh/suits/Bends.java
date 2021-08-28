package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.asanas.UrdhvaHastasana;
import com.github.lazyf1sh.util.YogaConfig;

import java.io.IOException;

import static com.github.lazyf1sh.util.Util.readFile;

public class Bends {

    private final YogaConfig yogaConfig;

    public Bends(final YogaConfig yogaConfig) {
        this.yogaConfig = yogaConfig;
    }

    public String buildBendsSession() throws IOException {
        final StringBuilder result = new StringBuilder();

        result.append(new Warmup(yogaConfig).build());
        result.append(new UrdhvaHastasana(yogaConfig).urdhvaHastasanaOnTiptoes());
        result.append(readFile("f2238bca3e1b.txt"));
        result.append(getBendsBody());
        result.append(new Outro().build());

        return result.toString();
    }

    private static String getBendsBody() throws IOException {
        return readFile("bends-body.txt");
    }
}
