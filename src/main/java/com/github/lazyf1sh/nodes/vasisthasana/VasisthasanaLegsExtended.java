package com.github.lazyf1sh.nodes.vasisthasana;



import com.github.lazyf1sh.nodes.Asana;

import java.io.IOException;

public class VasisthasanaLegsExtended extends Asana {



    private VasisthasanaLegsExtended() {
        
    }

    public static String vasisthasanaLegExtended() throws IOException {
        return new VasisthasanaLegsExtended().build();
    }


}
