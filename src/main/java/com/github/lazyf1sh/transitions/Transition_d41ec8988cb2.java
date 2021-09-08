package com.github.lazyf1sh.transitions;

import com.github.lazyf1sh.suits.YogaSessionTextBuilder;
import com.github.lazyf1sh.util.YogaConfig;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Transition_d41ec8988cb2 extends YogaSessionTextBuilder {
    public Transition_d41ec8988cb2(final YogaConfig yogaConfig, final Path path) {
        super(yogaConfig, path);
    }

    public static Transition_d41ec8988cb2 build(final YogaConfig yogaConfig) {
        return new Transition_d41ec8988cb2(yogaConfig, Paths.get("transitions/d41ec8988cb2"));
    }
}
