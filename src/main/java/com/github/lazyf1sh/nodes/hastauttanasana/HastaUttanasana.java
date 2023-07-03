package com.github.lazyf1sh.nodes.hastauttanasana;

import com.github.lazyf1sh.nodes.Asana;

import java.io.IOException;

public class HastaUttanasana extends Asana {

    private HastaUttanasana() {

    }

    public static String hastaUttanasana() throws IOException {
        return new HastaUttanasana().build();
    }
}
