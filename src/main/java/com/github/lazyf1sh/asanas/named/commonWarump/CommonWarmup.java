package com.github.lazyf1sh.asanas.named.commonWarump;

import com.github.lazyf1sh.asanas.named.tadasana.TadasanaPalmsInNamaste;
import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.domain.Suite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.github.lazyf1sh.asanas.named.balasana.Balasana.balasana;
import static com.github.lazyf1sh.asanas.named.bitilasana.Bitilasana.bitilasana;
import static com.github.lazyf1sh.asanas.named.marjariasana.Marjariasana.marjariasana;
import static com.github.lazyf1sh.asanas.named.marjariasana.MarjariasanaKneeToForehead.marjariasanaKneeToForehead;
import static com.github.lazyf1sh.asanas.unnamed.a7d8c46afd699.a7d8c46afd699;
import static com.github.lazyf1sh.asanas.unnamed.t3ebc07c8470b.t3ebc07c8470b;
import static com.github.lazyf1sh.domain.ReadAsanaParams.readAsanaParams;
import static com.github.lazyf1sh.util.Util.readConventionalWayTxt;

public class CommonWarmup implements Suite {

    public List<SourceFile> build() throws IOException {
        List<SourceFile> warmup = new ArrayList<>();

        warmup.add(new TadasanaPalmsInNamaste().build());
        warmup.add(a7d8c46afd699());
        warmup.add(balasana());
        warmup.add(t3ebc07c8470b());
        warmup.add(bitilasana());
        warmup.add(marjariasana());
        warmup.add(bitilasana());
        warmup.add(marjariasana());
        warmup.add(marjariasanaKneeToForehead());
        warmup.add(readConventionalWayTxt(readAsanaParams().resourceBundleClass(this.getClass())));


        return warmup;
    }
}
