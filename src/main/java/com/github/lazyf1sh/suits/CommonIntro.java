package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.nodes.balasana.Balasana;
import com.github.lazyf1sh.transitions.Transition_3ebc07c8470b;
import com.github.lazyf1sh.transitions.Unnamed_7d8c46afd699;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.github.lazyf1sh.nodes.bitilasana.Bitilasana.bitilasana;
import static com.github.lazyf1sh.nodes.marjariasana.Marjariasana.marjariasana;
import static com.github.lazyf1sh.nodes.marjariasana.MarjariasanaKneeToForehead.marjariasanaKneeToForehead;
import static com.github.lazyf1sh.nodes.tadasana.TadasanaPalmsInNamaste.tadasanaPalmsInNamaste;
import static com.github.lazyf1sh.util.ReadAsanaParams.readAsanaParams;
import static com.github.lazyf1sh.util.Util.readConventionalWay;

public class CommonIntro
{


    public List<SourceFile> build() throws IOException
    {
        final List<SourceFile> warmup = new ArrayList<>();

        warmup.add(tadasanaPalmsInNamaste());
        warmup.add(new Unnamed_7d8c46afd699().build());
        warmup.add(new Balasana().build());
        warmup.add(new Transition_3ebc07c8470b().build());
        warmup.add(bitilasana());
        warmup.add(marjariasana());
        warmup.add(bitilasana());
        warmup.add(marjariasana());
        warmup.add(marjariasanaKneeToForehead());
        warmup.add(readConventionalWay(readAsanaParams().resourceBundleClass(this.getClass())));


        return warmup;
    }
}
