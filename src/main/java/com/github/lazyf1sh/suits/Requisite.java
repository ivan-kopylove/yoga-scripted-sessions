package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.util.YogaConfig;

import java.nio.file.Paths;

public class Requisite extends YogaSessionTextBuilder {

    public Requisite(final YogaConfig yogaConfig) {
        super(yogaConfig, Paths.get("infrastructure/requisite"));
    }
}
