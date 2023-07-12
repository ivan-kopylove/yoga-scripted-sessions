package com.github.lazyf1sh.nodes.commonIntro;

import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.nodes.balasana.Balasana;
import com.github.lazyf1sh.nodes.unnamed.Transition_3ebc07c8470b;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.github.lazyf1sh.nodes.bitilasana.Bitilasana.bitilasana;
import static com.github.lazyf1sh.nodes.marjariasana.Marjariasana.marjariasana;
import static com.github.lazyf1sh.nodes.marjariasana.MarjariasanaKneeToForehead.marjariasanaKneeToForehead;
import static com.github.lazyf1sh.nodes.tadasana.TadasanaPalmsInNamaste.tadasanaPalmsInNamaste;
import static com.github.lazyf1sh.nodes.unnamed.a7d8c46afd699.a7d8c46afd699;
import static com.github.lazyf1sh.util.ReadAsanaParams.readAsanaParams;
import static com.github.lazyf1sh.util.Util.readConventionalWay;

public class CommonIntro
{

    public List<SourceFile> build() throws IOException
    {
        final List<SourceFile> warmup = new ArrayList<>();

        warmup.add(tadasanaPalmsInNamaste());
        warmup.add(a7d8c46afd699());
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
