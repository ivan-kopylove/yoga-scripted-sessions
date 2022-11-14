package com.github.lazyf1sh.nodes.tadasana;


import com.github.lazyf1sh.nodes.Asana;

import java.io.IOException;

public class Tadasana extends Asana {

    private Tadasana() {

    }


    public static String tadasana() throws IOException {
        return new Tadasana().build();
    }
}
