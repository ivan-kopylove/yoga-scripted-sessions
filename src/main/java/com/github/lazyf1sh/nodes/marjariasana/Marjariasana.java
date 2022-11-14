package com.github.lazyf1sh.nodes.marjariasana;

import com.github.lazyf1sh.nodes.Asana;

import java.io.IOException;

public class Marjariasana extends Asana {

    private Marjariasana() {
    }

    public static String marjariasana() throws IOException {
        return new Marjariasana().build();
    }

}
