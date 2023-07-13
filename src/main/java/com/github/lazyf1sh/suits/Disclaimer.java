package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.nodes.Asana;

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
