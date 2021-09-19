package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.util.YogaConfig;

import java.io.IOException;
import java.nio.file.Path;

import static com.github.lazyf1sh.util.Util.readFile;

public abstract class YogaSessionTextBuilder {

    protected final YogaConfig yogaConfig;
    protected final Path path;

    public YogaSessionTextBuilder(final YogaConfig yogaConfig, final Path path) {
        this.yogaConfig = yogaConfig;
        this.path = path;
    }

    public String build() throws IOException {
        return readFile(path, yogaConfig.getLanguage());
    }
}
