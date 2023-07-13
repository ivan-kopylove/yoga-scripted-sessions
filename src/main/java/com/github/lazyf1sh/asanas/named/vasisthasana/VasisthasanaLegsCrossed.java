package com.github.lazyf1sh.asanas.named.vasisthasana;

import com.github.lazyf1sh.asanas.Asana;
import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;

public class VasisthasanaLegsCrossed extends Asana
{

    private VasisthasanaLegsCrossed()
    {

    }

    public static SourceFile vasisthasanaLegsCrossed() throws IOException
    {
        return new VasisthasanaLegsCrossed().build();
    }
}
