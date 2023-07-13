package com.github.lazyf1sh.asanas.named.bitilasana.makarasana;

import com.github.lazyf1sh.asanas.Asana;
import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;

public class Makarasana extends Asana
{

    private Makarasana()
    {
    }

    public static SourceFile makarasana() throws IOException
    {
        return new Makarasana().build();
    }
}
