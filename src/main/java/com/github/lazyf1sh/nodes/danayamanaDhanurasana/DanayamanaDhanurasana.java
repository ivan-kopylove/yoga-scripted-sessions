package com.github.lazyf1sh.nodes.danayamanaDhanurasana;

import com.github.lazyf1sh.nodes.Asana;

import java.io.IOException;

public class DanayamanaDhanurasana extends Asana {

    private DanayamanaDhanurasana() {
    }

    public static String danayamanaDhanurasana() throws IOException {
        return new DanayamanaDhanurasana().build();
    }
}
