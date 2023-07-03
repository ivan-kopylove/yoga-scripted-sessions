package com.github.lazyf1sh.nodes.ardhaUttanasana;


import com.github.lazyf1sh.nodes.Asana;

import java.io.IOException;

public class ArdhaUttanasana extends Asana {

    private ArdhaUttanasana() {

    }

    public static String ardhaUttanasana() throws IOException {
        return new ArdhaUttanasana().build();
    }
}
