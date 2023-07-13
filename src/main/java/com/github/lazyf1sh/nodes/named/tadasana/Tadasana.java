package com.github.lazyf1sh.nodes.named.tadasana;

import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.nodes.Asana;

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
