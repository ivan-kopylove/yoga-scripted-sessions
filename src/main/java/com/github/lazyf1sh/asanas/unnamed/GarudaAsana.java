package com.github.lazyf1sh.asanas.unnamed;

import com.github.lazyf1sh.asanas.Asana;
import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;

public class GarudaAsana extends Asana
{

    private GarudaAsana()
    {

    }

    public static SourceFile garudaAsana() throws IOException
    {
        return new GarudaAsana().build();
    }
}
