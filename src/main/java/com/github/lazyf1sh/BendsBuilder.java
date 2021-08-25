package com.github.lazyf1sh;

import java.io.IOException;

import static com.github.lazyf1sh.AsanasBuilder.*;
import static com.github.lazyf1sh.Util.readFile;

public class BendsBuilder {
    public String buildBendsSession() throws IOException {
        StringBuilder result = new StringBuilder();
        result.append(buildCommonIntro("ru"));
        result.append(urdhvaHastasanaOnTiptoes());
        result.append(readFile("f2238bca3e1b.txt"));
        result.append(getBendsBody());
        result.append(buildCommonOutro());
        return result.toString();
    }

    private static String getBendsBody() throws IOException {
        return readFile("bends-body.txt");
    }
}
