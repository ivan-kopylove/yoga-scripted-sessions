package com.github.lazyf1sh.nodes.bitilasana;

import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.nodes.Asana;

import java.io.IOException;

public class Bitilasana extends Asana {

    private Bitilasana() {

    }

    public static SourceFile bitilasana() throws IOException {
        return new Bitilasana().build();
    }
}
