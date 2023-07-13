package com.github.lazyf1sh.asanas.named.suryaNamaskar;

import com.github.lazyf1sh.asanas.Asana;
import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;

public class SuryaNamaskarSides extends Asana
{

    private SuryaNamaskarSides()
    {

    }

    public static SourceFile suryaNamaskarSides() throws IOException
    {
        return new SuryaNamaskarSides().build();
    }
}
