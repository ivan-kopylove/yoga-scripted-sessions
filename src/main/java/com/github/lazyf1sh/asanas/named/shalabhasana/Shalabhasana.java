package com.github.lazyf1sh.asanas.named.shalabhasana;

import com.github.lazyf1sh.asanas.Asana;
import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;

public class Shalabhasana extends Asana
{

    private Shalabhasana()
    {
    }

    public static SourceFile shalabhasana() throws IOException
    {
        return new Shalabhasana().build();
    }
}
