package com.github.lazyf1sh.asanas;

import com.github.lazyf1sh.suits.YogaSessionTextBuilder;
import com.github.lazyf1sh.util.YogaConfig;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Bitilasana extends YogaSessionTextBuilder {

    public Bitilasana(final YogaConfig yogaConfig, final Path path) {
        super(yogaConfig, path);
    }

    public static Bitilasana build(final YogaConfig yogaConfig) {
        return new Bitilasana(yogaConfig, Paths.get("asanas/bitilasana/bitilasana-payload"));
    }
}
