package com.github.lazyf1sh.asanas;

import com.github.lazyf1sh.microtype.FileName;
import com.github.lazyf1sh.util.YogaConfig;

import java.io.IOException;

import static com.github.lazyf1sh.util.Util.readFile;

public abstract class Asana {
    private final YogaConfig yogaConfig;
    private final FileName filename;

    protected Asana(final YogaConfig yogaConfig, final FileName filename) {
        this.yogaConfig = yogaConfig;
        this.filename = filename;
    }

    public String build() throws IOException {
        return readFile(filename.getFileName(), yogaConfig.getLanguage());
    }
}
