package com.github.lazyf1sh.nodes.makarasana;


import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.nodes.Asana;

import java.io.IOException;

public class Makarasana extends Asana {

    private Makarasana() {
    }

    public static SourceFile makarasana() throws IOException {
        return new Makarasana().build();
    }
}
