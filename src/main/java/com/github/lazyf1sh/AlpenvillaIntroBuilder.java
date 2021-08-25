package com.github.lazyf1sh;

import java.io.IOException;

import static com.github.lazyf1sh.Util.readFile;

public class AlpenvillaIntroBuilder {

    public String buildAlpenVillaIntro() throws IOException {
        StringBuilder result = new StringBuilder();
        result.append(readFile("alpenvilla-intro.txt"));
        return result.toString();
    }
}
