package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.transitions.Unnamed_f2238bca3e1b;


import java.io.IOException;
import java.nio.file.Paths;

import static com.github.lazyf1sh.nodes.hastauttanasana.HastaUttanasana.hastaUttanasana;
import static com.github.lazyf1sh.transitions.GenericTransition.genericTransition;

public class LegSplit {

    

    private LegSplit() {
        
    }

    public String build() throws IOException {
        final StringBuilder result = new StringBuilder();

        result.append("\n");
        result.append(new CommonIntro().build());
        result.append(new Unnamed_f2238bca3e1b().build());
        result.append(genericTransition(Paths.get("5d5160263051")));
        result.append(hastaUttanasana());
        result.append("\n");

        return result.toString();
    }

    public static String legSplitSession() throws IOException {
        return new LegSplit().build();
    }
}
