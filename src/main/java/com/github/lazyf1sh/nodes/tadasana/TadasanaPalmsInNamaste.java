package com.github.lazyf1sh.nodes.tadasana;


import com.github.lazyf1sh.nodes.Asana;

import java.io.IOException;

public class TadasanaPalmsInNamaste extends Asana {

    private TadasanaPalmsInNamaste() {

    }

    public static String tadasanaPalmsInNamaste() throws IOException {
        return new TadasanaPalmsInNamaste().build();
    }
}
