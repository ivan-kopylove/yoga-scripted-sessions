package com.github.lazyf1sh.nodes.known.vasisthasana;

import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.nodes.Asana;

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
