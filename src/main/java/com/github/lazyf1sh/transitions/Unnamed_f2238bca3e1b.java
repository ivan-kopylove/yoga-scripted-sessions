package com.github.lazyf1sh.transitions;

import com.github.lazyf1sh.util.YogaConfig;

import java.io.IOException;

import static com.github.lazyf1sh.util.Util.readFile;

public class Unnamed_f2238bca3e1b {

    private final YogaConfig yogaConfig;

    public Unnamed_f2238bca3e1b(final YogaConfig yogaConfig) {
        this.yogaConfig = yogaConfig;
    }

    public String build() throws IOException {
        return readFile("transitions/f2238bca3e1b", yogaConfig.getLanguage());
    }
}
