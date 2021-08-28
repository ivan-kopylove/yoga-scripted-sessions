package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.util.YogaConfig;

import java.nio.file.Paths;

public class Disclaimer extends YogaSessionTextBuilder {

    public Disclaimer(final YogaConfig yogaConfig) {
        super(yogaConfig, Paths.get("infrastructure/disclaimer"));
    }
}
