package com.github.lazyf1sh.asanas.named.commonWarump;

import com.github.lazyf1sh.asanas.named.balasana.Balasana;
import com.github.lazyf1sh.asanas.named.bitilasana.Bitilasana;
import com.github.lazyf1sh.asanas.named.marjariasana.Marjariasana;
import com.github.lazyf1sh.asanas.named.marjariasana.MarjariasanaKneeToForehead;
import com.github.lazyf1sh.asanas.named.tadasana.TadasanaPalmsInNamaste;
import com.github.lazyf1sh.asanas.unnamed.*;
import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.domain.Suite;

import java.io.IOException;
import java.util.List;


public class CommonWarmup implements Suite {

    public List<Class<?>> build() throws IOException {
        return List.of(
                        TadasanaPalmsInNamaste.class,
                        a7d8c46afd699.class,
                        Balasana.class,
                        t3ebc07c8470b.class,
                        Bitilasana.class,
                        Marjariasana.class,
                        Bitilasana.class,
                        Marjariasana.class,
                        MarjariasanaKneeToForehead.class,
                        CommonWarmup.class
                );
    }
}
