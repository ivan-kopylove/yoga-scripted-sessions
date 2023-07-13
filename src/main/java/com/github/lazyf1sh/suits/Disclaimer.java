package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.asanas.Asana;
import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;

public class Disclaimer extends Asana
{

    private Disclaimer()
    {

    }

    public static SourceFile disclaimer() throws IOException
    {
        return new Disclaimer().build();
    }
}
