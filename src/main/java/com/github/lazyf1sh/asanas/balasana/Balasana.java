package com.github.lazyf1sh.asanas.balasana;

import com.github.lazyf1sh.suits.YogaSessionTextBuilder;
import com.github.lazyf1sh.util.YogaConfig;

import java.nio.file.Paths;

public class Balasana extends YogaSessionTextBuilder {
    public Balasana(final YogaConfig yogaConfig) {
        super(yogaConfig, Paths.get("asanas/balasana/balasana-payload"));
    }
}
