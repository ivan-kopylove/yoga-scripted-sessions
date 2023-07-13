package com.github.lazyf1sh.asanas.named.marjariasana;

import com.github.lazyf1sh.asanas.Asana;
import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;

public class Marjariasana extends Asana
{

    private Marjariasana()
    {
    }

    public static SourceFile marjariasana() throws IOException
    {
        return new Marjariasana().build();
    }
}
