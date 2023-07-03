package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.nodes.balasana.Balasana;
import com.github.lazyf1sh.transitions.Transition_3ebc07c8470b;
import com.github.lazyf1sh.transitions.Unnamed_7d8c46afd699;

import java.io.IOException;

import static com.github.lazyf1sh.nodes.bitilasana.Bitilasana.bitilasana;
import static com.github.lazyf1sh.nodes.marjariasana.Marjariasana.marjariasana;
import static com.github.lazyf1sh.nodes.marjariasana.MarjariasanaKneeToForehead.marjariasanaKneeToForehead;
import static com.github.lazyf1sh.nodes.tadasana.TadasanaPalmsInNamaste.tadasanaPalmsInNamaste;
import static com.github.lazyf1sh.util.ReadAsanaParams.readAsanaParams;
import static com.github.lazyf1sh.util.Util.readConventionalWay;

public class CommonIntro {


    public String build() throws IOException {
        final StringBuilder warmup = new StringBuilder();

        warmup.append(tadasanaPalmsInNamaste());
        warmup.append(new Unnamed_7d8c46afd699().build());
        warmup.append(new Balasana().build());
        warmup.append(new Transition_3ebc07c8470b().build());
        warmup.append(bitilasana());
        warmup.append(marjariasana());
        warmup.append(bitilasana());
        warmup.append(marjariasana());
        warmup.append(marjariasanaKneeToForehead());
        warmup.append(readConventionalWay(readAsanaParams().resourceBundleClass(this.getClass())));
        warmup.append("\n");

        return warmup.toString();
    }
}
