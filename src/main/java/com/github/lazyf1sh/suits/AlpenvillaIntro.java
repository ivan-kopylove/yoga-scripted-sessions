package com.github.lazyf1sh.suits;

import java.io.IOException;

import static com.github.lazyf1sh.util.Util.readFile;

public class AlpenvillaIntro {

    public String buildAlpenVillaIntro() throws IOException {
        final StringBuilder result = new StringBuilder();
        result.append(readFile("alpenvilla-intro.txt"));
        return result.toString();
    }
}
