package com.github.lazyf1sh.nodes.unnamed;

import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.nodes.Asana;

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
