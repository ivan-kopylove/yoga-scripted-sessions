package com.github.lazyf1sh.nodes.dhanurasana;

import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.nodes.Asana;

import java.io.IOException;

public class Dhanurasana extends Asana {
    private Dhanurasana() {
        super();
    }


    public static SourceFile dhanurasana() throws IOException {
        return new Dhanurasana().build();
    }
}
