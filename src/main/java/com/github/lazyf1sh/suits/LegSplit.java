package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.transitions.Unnamed_f2238bca3e1b;

import java.io.IOException;
import java.nio.file.Paths;

import static com.github.lazyf1sh.nodes.hastauttanasana.HastaUttanasana.hastaUttanasana;
import static com.github.lazyf1sh.transitions.GenericTransition.genericTransition;

public class LegSplit {


    private LegSplit() {

    }

    public static String legSplitSession() throws IOException {
        return new LegSplit().build();
    }

    public String build() throws IOException {

        String result = "\n" +
                new CommonIntro().build() +
                new Unnamed_f2238bca3e1b().build() +
                genericTransition(Paths.get("5d5160263051")) +
                hastaUttanasana() +
                "\n";

        return result;
    }
}
