package com.github.lazyf1sh.asanas.named.bitilasana;

import com.github.lazyf1sh.asanas.Asana;
import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;

public class Bitilasana extends Asana
{

    private Bitilasana()
    {

    }

    public static SourceFile bitilasana() throws IOException
    {
        return new Bitilasana().build();
    }
}
