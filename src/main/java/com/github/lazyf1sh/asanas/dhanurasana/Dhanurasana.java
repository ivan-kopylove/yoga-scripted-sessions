package com.github.lazyf1sh.asanas.dhanurasana;

import com.github.lazyf1sh.asanas.Asana;
import com.github.lazyf1sh.microtype.FileName;


import java.io.IOException;

import static com.github.lazyf1sh.util.Util.readFile;

public class Dhanurasana extends Asana {
    public Dhanurasana() {
        super(new FileName("asanas/dhanurasana/dhanurasana-payload"));
    }

    public String dandayamana() throws IOException {
        return readFile("asanas/dhanurasana/danayamana-dhanurasana-payload", "ru");
    }
}
