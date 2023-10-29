package com.github.lazyf1sh.asanas.named.agnisarKriya;

import com.github.lazyf1sh.asanas.Asana;
import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;

public class AgnisarKriya extends Asana {

    private AgnisarKriya() {

    }

    public static SourceFile agnisarKriya() throws IOException {
        return new AgnisarKriya().build();
    }
}
