package com.github.lazyf1sh.asanas;

import com.github.lazyf1sh.microtype.FileName;
import com.github.lazyf1sh.util.YogaConfig;

import java.io.IOException;

import static com.github.lazyf1sh.util.Util.readFile;

public abstract class Asana {
    protected final YogaConfig yogaConfig;
    protected final FileName filename;

    protected Asana(final YogaConfig yogaConfig, final FileName filename) {
        this.yogaConfig = yogaConfig;
        this.filename = filename;
    }

    public String build() throws IOException {
        return readFile(filename.getValue(), yogaConfig.getLanguage());
    }
}
