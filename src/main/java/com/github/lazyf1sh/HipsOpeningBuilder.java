package com.github.lazyf1sh;

import com.github.lazyf1sh.asanas.transitions.Transitionad96a996f0ca;

import java.io.IOException;

import static com.github.lazyf1sh.AsanasBuilder.buildCommonIntro;
import static com.github.lazyf1sh.AsanasBuilder.urdhvaHastasanaOnTiptoes;
import static com.github.lazyf1sh.Util.readFile;

public class HipsOpeningBuilder {
    public String buildHipsOpeningSession() throws IOException {
        StringBuilder result = new StringBuilder();
        result.append(buildCommonIntro("ru"));
        result.append(urdhvaHastasanaOnTiptoes());
        result.append(readFile("f2238bca3e1b.txt"));
        result.append(new Transitionad96a996f0ca().build());
        result.append(getHipsOpeningBody());
        result.append(AsanasBuilder.buildCommonOutro());
        return result.toString();
    }

    private static String getHipsOpeningBody() throws IOException {
        return readFile("hips-opening-body.txt");
    }
}
