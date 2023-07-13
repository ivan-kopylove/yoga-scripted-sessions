package com.github.lazyf1sh.asanas.named.vasisthasana;

import com.github.lazyf1sh.asanas.Asana;
import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;

public class VasisthasanaLegsExtended extends Asana
{

    private VasisthasanaLegsExtended()
    {

    }

    public static SourceFile vasisthasanaLegExtended() throws IOException
    {
        return new VasisthasanaLegsExtended().build();
    }
}
