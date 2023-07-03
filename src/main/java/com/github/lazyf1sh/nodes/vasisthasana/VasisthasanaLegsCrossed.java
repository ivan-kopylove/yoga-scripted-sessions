package com.github.lazyf1sh.nodes.vasisthasana;


import com.github.lazyf1sh.nodes.Asana;

import java.io.IOException;

public class VasisthasanaLegsCrossed extends Asana {


    private VasisthasanaLegsCrossed() {

    }

    public static String vasisthasanaLegsCrossed() throws IOException {
        return new VasisthasanaLegsCrossed().build();
    }

}
