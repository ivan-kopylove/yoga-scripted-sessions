package com.github.lazyf1sh.transitions;

import com.github.lazyf1sh.util.YogaConfig;

import java.io.IOException;

import static com.github.lazyf1sh.util.Util.readFile;

public class Unnamed_0cdcbfb6458d {

    private final YogaConfig yogaConfig;

    public Unnamed_0cdcbfb6458d(final YogaConfig yogaConfig) {
        this.yogaConfig = yogaConfig;
    }

    public String build() throws IOException {
        return readFile("transitions/0cdcbfb6458d", yogaConfig.getLanguage());
    }
}
