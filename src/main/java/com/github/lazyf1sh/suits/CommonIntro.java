package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.nodes.balasana.Balasana;
import com.github.lazyf1sh.nodes.tadasana.Tadasana;
import com.github.lazyf1sh.transitions.Transition_3ebc07c8470b;
import com.github.lazyf1sh.transitions.Unnamed_7d8c46afd699;


import java.io.IOException;
import java.nio.file.Paths;

import static com.github.lazyf1sh.nodes.bitilasana.Bitilasana.bitilasana;
import static com.github.lazyf1sh.nodes.marjariasana.Marjariasana.marjariasana;
import static com.github.lazyf1sh.util.Util.readFile;

public class CommonIntro {



    public String build() throws IOException {
        final StringBuilder warmup = new StringBuilder();

        warmup.append(new Requisite().build());
        warmup.append(new Tadasana().palmsInNamaste());
        warmup.append(new Unnamed_7d8c46afd699().build());
        warmup.append(new Balasana().build());
        warmup.append(new Transition_3ebc07c8470b().build());
        warmup.append(bitilasana().build());
        warmup.append(marjariasana().build());
        warmup.append(bitilasana().skipRussianName().skipSanskritName().build());
        warmup.append(marjariasana().build());
        warmup.append(marjariasana().kneeToForeHead());

        warmup.append(readFile(Paths.get("common-intro"), "ru")).append("\n");

        return warmup.toString();
    }
}
