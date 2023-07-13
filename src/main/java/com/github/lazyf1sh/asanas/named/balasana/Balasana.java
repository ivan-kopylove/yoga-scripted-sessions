package com.github.lazyf1sh.asanas.named.balasana;

import com.github.lazyf1sh.asanas.Asana;
import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;

public class Balasana extends Asana
{

    private Balasana()
    {

    }

    public static SourceFile balasana() throws IOException
    {
        return new Balasana().build();
    }
}
