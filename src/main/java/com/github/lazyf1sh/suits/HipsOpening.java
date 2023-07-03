package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.transitions.Unnamed_f2238bca3e1b;

import java.io.IOException;
import java.nio.file.Paths;

import static com.github.lazyf1sh.nodes.urdhvaHastasana.UrdhvaHastasanaOnTipToes.urdhvaHastasanaOnTipToes;
import static com.github.lazyf1sh.transitions.GenericTransition.genericTransition;
import static com.github.lazyf1sh.util.Util.readFile;

public class HipsOpening {


    public HipsOpening() {

    }

    private static String getHipsOpeningBody() throws IOException {
        return readFile("hips-opening-body.txt");
    }

    public String build() throws IOException {


        String result = urdhvaHastasanaOnTipToes() +
                new Unnamed_f2238bca3e1b().build() +
                genericTransition(Paths.get("ad96a996f0ca")) +
                getHipsOpeningBody() +
                new Outro().build() +
                "\n";

        return result;
    }
}
