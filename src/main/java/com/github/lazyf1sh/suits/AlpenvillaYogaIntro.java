package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.util.YogaConfig;

import java.io.IOException;

import static com.github.lazyf1sh.util.Util.readFile;

public class AlpenvillaYogaIntro {

    private final YogaConfig yogaConfig;

    public AlpenvillaYogaIntro(final YogaConfig yogaConfig) {

        this.yogaConfig = yogaConfig;
    }

    public String build() throws IOException {
        final StringBuilder result = new StringBuilder();
        final String path = String.format("alpenvilla-intro-%s.txt", yogaConfig.getLanguage());
        result.append(readFile(path));
        return result.toString();
    }
}
