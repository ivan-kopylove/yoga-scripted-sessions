package com.github.lazyf1sh.asanas;

import com.github.lazyf1sh.microtype.FileName;


import java.io.IOException;

import static com.github.lazyf1sh.util.Util.readFile;

public abstract class Asana {
    protected final FileName filename;

    protected Asana(final FileName filename) {
        this.filename = filename;
    }

    public String build() throws IOException {
        return readFile(filename.getValue(), "ru");
    }
}
