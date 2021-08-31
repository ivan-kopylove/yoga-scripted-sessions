package com.github.lazyf1sh.asanas;

import com.github.lazyf1sh.suits.YogaSessionTextBuilder;
import com.github.lazyf1sh.util.YogaConfig;

import java.nio.file.Paths;

public class Shalabhasana extends YogaSessionTextBuilder {

    public Shalabhasana(final YogaConfig yogaConfig) {
        super(yogaConfig, Paths.get("asanas/shalabhasana/shalabhasana-payload"));
    }
}
