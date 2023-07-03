package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.transitions.Unnamed_f2238bca3e1b;

import java.io.IOException;
import java.nio.file.Paths;

import static com.github.lazyf1sh.nodes.urdhvaHastasana.UrdhvaHastasanaOnTipToes.urdhvaHastasanaOnTipToes;
import static com.github.lazyf1sh.transitions.GenericTransition.genericTransition;
import static com.github.lazyf1sh.util.ReadAsanaParams.readAsanaParams;
import static com.github.lazyf1sh.util.Util.readConventionalWay;

public class HipsOpening {


    private HipsOpening() {

    }

    public static String hipsOpening() throws IOException {
        String result = urdhvaHastasanaOnTipToes() +
                new Unnamed_f2238bca3e1b().build() +
                genericTransition(Paths.get("ad96a996f0ca")) +
                readConventionalWay(readAsanaParams().resourceBundleClass(HipsOpening.class));

        return result;
    }
}
