package com.github.lazyf1sh.transitions;

import com.github.lazyf1sh.util.YogaConfig;

import java.io.IOException;

import static com.github.lazyf1sh.util.Util.readFile;

public class Transition_dc1053e8d71f {

    private YogaConfig yogaConfig;

    public Transition_dc1053e8d71f(final YogaConfig yogaConfig) {
        this.yogaConfig = yogaConfig;
    }

    public String build() throws IOException {
        return readFile("f2238bca3e1b", yogaConfig.getLanguage());
    }
}
