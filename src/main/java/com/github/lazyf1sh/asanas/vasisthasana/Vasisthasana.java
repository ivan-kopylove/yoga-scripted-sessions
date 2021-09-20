package com.github.lazyf1sh.asanas.vasisthasana;

import com.github.lazyf1sh.util.YogaConfig;

import java.io.IOException;

import static com.github.lazyf1sh.util.Util.readFile;

public class Vasisthasana {

    private final YogaConfig yogaConfig;

    public Vasisthasana(final YogaConfig yogaConfig) {
        this.yogaConfig = yogaConfig;
    }

    /**
     * google side-plank-pose-variation-legs-crossed https://imgur.com/a/UCoablH
     */
    public String legsCrossed() throws IOException {
        return readFile("asanas/vasisthasana/vasisthasana-legs-crossed-payload", yogaConfig.getLanguage());
    }

    public String legExtended() throws IOException {
        return readFile("asanas/vasisthasana/vasisthasana-leg-extended-payload", yogaConfig.getLanguage());
    }

}
