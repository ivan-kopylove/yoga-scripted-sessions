package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.nodes.urdhvaHastasana.UrdhvaHastasana;
import com.github.lazyf1sh.transitions.Transition_d41ec8988cb2;
import com.github.lazyf1sh.transitions.Unnamed_2acd3f67e8ed;


import java.io.IOException;
import java.nio.file.Paths;

import static com.github.lazyf1sh.nodes.agnisarKriya.AgnisarKriya.agnisarKriya;
import static com.github.lazyf1sh.nodes.bitilasana.Bitilasana.bitilasana;
import static com.github.lazyf1sh.nodes.tadasana.Tadasana.quickTadasana;
import static com.github.lazyf1sh.transitions.GenericTransition.genericTransition;
import static com.github.lazyf1sh.util.Util.readFile;

public class SuryaNamaskar {
    

    public SuryaNamaskar() {

        
    }

    @SuppressWarnings("StringBufferReplaceableByString")
    public String build() throws IOException {
        final StringBuilder result = new StringBuilder();


        result.append(new Disclaimer().build());
        result.append(new CommonIntro().build());
        result.append(roundOne());
        result.append(roundTwo());
        result.append(readFile("surya-namaskar-round-03.txt"));
        result.append(readFile("ardha-uttanasana-with-standing-point.txt"));
        result.append(readFile("kapalabhati.txt"));
        result.append(agnisarKriya());
        result.append(Transition_d41ec8988cb2.build2());
        result.append(bitilasana().build());
        result.append(readFile("marjariasana-with-knee-to-elbow.txt"));
        result.append(readFile("dandayamana-Bharmanasana-balancing-table.txt"));
        result.append(readFile("eka-hasta-vjagrasana-cross-hook.txt"));
        result.append(readFile("eka-pada-adho-mukha-svanasana-with-elbow-down.txt"));
        result.append(genericTransition(Paths.get("ef2eb0af2276")));
        result.append(readFile("dolphin.txt"));
        result.append(genericTransition(Paths.get("b21ef52bd090")));
        result.append(readFile("spring-of-leg-moved-to-a-side.txt"));
        result.append(readFile("transition-266ae7aacbff.txt"));
        result.append(readFile("rotate-a-knee-outwards.txt"));
        result.append(genericTransition(Paths.get("d856222abcd5")));
        result.append(readFile("big-toe-to-ear.txt"));
        result.append(readFile("eka-hasta-vjagrasana-one-side-hook.txt"));
        result.append(readFile("surya-namaskar-sides.txt"));
        result.append(new Outro().build());

        return result.toString();
    }

    private String roundTwo() throws IOException {
        final StringBuilder result = new StringBuilder();
        result.append(quickTadasana());
        result.append(readFile("surya-namaskar-round-02.txt"));
        return result.toString();
    }

    @SuppressWarnings("StringBufferReplaceableByString")
    private String roundOne() throws IOException {
        final StringBuilder result = new StringBuilder();

        final UrdhvaHastasana urdhvaHastasana = new UrdhvaHastasana();


        result.append(urdhvaHastasana.urdhvaHastasanaOnTiptoes());
        result.append(urdhvaHastasana.build());
        result.append(new Unnamed_2acd3f67e8ed().build());
        result.append(readFile("surya-namaskar-round-01.txt"));
        return result.toString();
    }
}
