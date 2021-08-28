package com.github.lazyf1sh.transitions;

import com.github.lazyf1sh.util.YogaConfig;

import java.io.IOException;

import static com.github.lazyf1sh.util.Util.readFile;

public class Unnamed_d6054818ad4b {

    private final YogaConfig yogaConfig;

    public Unnamed_d6054818ad4b(final YogaConfig yogaConfig) {
        this.yogaConfig = yogaConfig;
    }

    public String build() throws IOException {
        return readFile("transitions/d6054818ad4b", yogaConfig.getLanguage());
    }
}
