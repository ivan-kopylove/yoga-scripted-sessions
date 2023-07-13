package com.github.lazyf1sh.asanas.named.tadasana;

import com.github.lazyf1sh.asanas.Asana;
import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;

public class Tadasana extends Asana
{

    private Tadasana()
    {

    }

    public static SourceFile tadasana() throws IOException
    {
        return new Tadasana().build();
    }
}
