package com.github.lazyf1sh.asanas;

import com.github.lazyf1sh.microtype.FileName;
import com.github.lazyf1sh.util.YogaConfig;

import java.io.IOException;

import static com.github.lazyf1sh.util.Util.readFile;

public class Dhanurasana extends Asana {

    private final YogaConfig yogaConfig;

    public Dhanurasana(final YogaConfig yogaConfig) {
        super(yogaConfig, new FileName("asanas/dhanurasana/dhanurasana-payload"));
        this.yogaConfig = yogaConfig;
    }

    public String dandayamana() throws IOException {
        return readFile("asanas/dhanurasana/danayamana-dhanurasana-payload", yogaConfig.getLanguage());
    }
}
