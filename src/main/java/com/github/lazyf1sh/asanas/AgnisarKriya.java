package com.github.lazyf1sh.asanas;

import com.github.lazyf1sh.suits.YogaSessionTextBuilder;
import com.github.lazyf1sh.util.YogaConfig;

import java.nio.file.Paths;

public class AgnisarKriya extends YogaSessionTextBuilder {
    public AgnisarKriya(final YogaConfig yogaConfig) {
        super(yogaConfig, Paths.get("asanas/agnisar-kriya/agnisar-kriya-payload"));
    }
}
