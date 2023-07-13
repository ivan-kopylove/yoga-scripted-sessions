package com.github.lazyf1sh.nodes.named.commonIntro;

import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.nodes.named.bitilasana.Bitilasana;
import com.github.lazyf1sh.nodes.named.marjariasana.Marjariasana;
import com.github.lazyf1sh.nodes.named.marjariasana.MarjariasanaKneeToForehead;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.github.lazyf1sh.nodes.named.balasana.Balasana.balasana;
import static com.github.lazyf1sh.nodes.named.tadasana.TadasanaPalmsInNamaste.tadasanaPalmsInNamaste;
import static com.github.lazyf1sh.nodes.unnamed.a7d8c46afd699.a7d8c46afd699;
import static com.github.lazyf1sh.nodes.unnamed.t3ebc07c8470b.t3ebc07c8470b;
import static com.github.lazyf1sh.util.ReadAsanaParams.readAsanaParams;
import static com.github.lazyf1sh.util.Util.readConventionalWay;

public class CommonWarmup
{

    public List<SourceFile> build() throws IOException
    {
        final List<SourceFile> warmup = new ArrayList<>();

        warmup.add(tadasanaPalmsInNamaste());
        warmup.add(a7d8c46afd699());
        warmup.add(balasana());
        warmup.add(t3ebc07c8470b());
        warmup.add(Bitilasana.bitilasana());
        warmup.add(Marjariasana.marjariasana());
        warmup.add(Bitilasana.bitilasana());
        warmup.add(Marjariasana.marjariasana());
        warmup.add(MarjariasanaKneeToForehead.marjariasanaKneeToForehead());
        warmup.add(readConventionalWay(readAsanaParams().resourceBundleClass(this.getClass())));


        return warmup;
    }
}
