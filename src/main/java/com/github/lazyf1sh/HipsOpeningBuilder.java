package com.github.lazyf1sh;

import java.io.IOException;

import static com.github.lazyf1sh.Util.readFile;

public class HipsOpeningBuilder {

    public String buildHipsOpeningSession() throws IOException {
        StringBuilder result = new StringBuilder();
        result.append(AsanasBuilder.buildCommonIntro("ru"));
        result.append(AsanasBuilder.urdhvaHastasanaOnTiptoes());
        result.append(readFile("f2238bca3e1b.txt"));
        result.append(getHipsOpeningBody());
        result.append(AsanasBuilder.buildCommonOutro());
        return result.toString();
    }

    private static String getHipsOpeningBody() throws IOException {
        return readFile("hips-opening-body.txt");
    }
}
