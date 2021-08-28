package com.github.lazyf1sh.suits;

import java.io.IOException;

import static com.github.lazyf1sh.util.Util.readFile;

public class Outro {

    public String build() throws IOException {
        return readFile("common-outro.txt");
    }
}
