package com.github.lazyf1sh.nodes.ekaPadaKaundiniAsanaSecondRightLeg;

import com.github.lazyf1sh.nodes.Asana;
import com.github.lazyf1sh.sides.Side;

import java.io.IOException;


public class EkaPadaKaundiniAsanaSecond extends Asana {

    private EkaPadaKaundiniAsanaSecond(Side side) {
        super(side);
    }

    public static String ekaPadaKaundiniAsanaSecond(Side side) throws IOException {
        return new EkaPadaKaundiniAsanaSecond(side).build();
    }
}
