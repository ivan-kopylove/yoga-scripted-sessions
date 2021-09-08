package com.github.lazyf1sh.asanas;

import com.github.lazyf1sh.suits.YogaSessionTextBuilder;
import com.github.lazyf1sh.util.YogaConfig;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Marjariasana extends YogaSessionTextBuilder {
    public Marjariasana(final YogaConfig yogaConfig, final Path path) {
        super(yogaConfig, path);
    }

    public static Marjariasana marjariasana(final YogaConfig yogaConfig) {
        return new Marjariasana(yogaConfig, Paths.get("asanas/marjariasana/marjariasana-payload"));
    }
}
