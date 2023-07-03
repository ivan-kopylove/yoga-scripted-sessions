package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.nodes.balasana.Balasana;
import com.github.lazyf1sh.transitions.Transition_3ebc07c8470b;
import com.github.lazyf1sh.transitions.Unnamed_7d8c46afd699;

import java.io.IOException;
import java.nio.file.Paths;

import static com.github.lazyf1sh.nodes.bitilasana.Bitilasana.bitilasana;
import static com.github.lazyf1sh.nodes.marjariasana.Marjariasana.marjariasana;
import static com.github.lazyf1sh.nodes.marjariasana.MarjariasanaKneeToForehead.marjariasanaKneeToForehead;
import static com.github.lazyf1sh.nodes.tadasana.TadasanaPalmsInNamaste.tadasanaPalmsInNamaste;
import static com.github.lazyf1sh.util.Util.readFile;

public class CommonIntro {


    public String build() throws IOException {

        String warmup = tadasanaPalmsInNamaste() +
                new Unnamed_7d8c46afd699().build() +
                new Balasana().build() +
                new Transition_3ebc07c8470b().build() +
                bitilasana() +
                marjariasana() +
                bitilasana() +
                marjariasana() +
                marjariasanaKneeToForehead() +
                readFile(Paths.get("common-intro"), "ru") +
                "\n";

        return warmup;
    }
}
