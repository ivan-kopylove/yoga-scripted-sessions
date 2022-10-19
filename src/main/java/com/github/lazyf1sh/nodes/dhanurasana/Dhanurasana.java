package com.github.lazyf1sh.nodes.dhanurasana;

import com.github.lazyf1sh.nodes.Asana;
import com.github.lazyf1sh.microtype.FileName;
import com.github.lazyf1sh.nodes.Asana2;


import java.io.IOException;

import static com.github.lazyf1sh.util.Util.readFile;

public class Dhanurasana extends Asana2 {
    private Dhanurasana() {
        super();
    }


    public static String dhanurasana() throws IOException {
        return new Dhanurasana().build();
    }
}
