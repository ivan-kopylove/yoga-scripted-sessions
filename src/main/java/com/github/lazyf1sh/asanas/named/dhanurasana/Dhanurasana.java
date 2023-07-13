package com.github.lazyf1sh.asanas.named.dhanurasana;

import com.github.lazyf1sh.asanas.Asana;
import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;

public class Dhanurasana extends Asana
{
    private Dhanurasana()
    {
        super();
    }

    public static SourceFile dhanurasana() throws IOException
    {
        return new Dhanurasana().build();
    }
}
