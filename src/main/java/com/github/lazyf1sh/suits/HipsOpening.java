package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.nodes.urdhvaHastasana.UrdhvaHastasana;
import com.github.lazyf1sh.transitions.Unnamed_f2238bca3e1b;


import java.io.IOException;
import java.nio.file.Paths;

import static com.github.lazyf1sh.transitions.GenericTransition.genericTransition;
import static com.github.lazyf1sh.util.Util.readFile;

public class HipsOpening {

    

    public HipsOpening() {
        
    }

    public String build() throws IOException {
        final StringBuilder result = new StringBuilder();


        result.append(new UrdhvaHastasana().urdhvaHastasanaOnTiptoes());
        result.append(new Unnamed_f2238bca3e1b().build());
        result.append(genericTransition(Paths.get("ad96a996f0ca")));

        result.append(getHipsOpeningBody());
        result.append(new Outro().build());
        result.append("\n");

        return result.toString();
    }

    private static String getHipsOpeningBody() throws IOException {
        return readFile("hips-opening-body.txt");
    }
}
