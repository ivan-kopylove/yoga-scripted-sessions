package com.github.lazyf1sh.asanas.named.ardhaUttanasana;

import com.github.lazyf1sh.asanas.Asana;
import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;

public class ArdhaUttanasana extends Asana
{

    private ArdhaUttanasana()
    {

    }

    public static SourceFile ardhaUttanasana() throws IOException
    {
        return new ArdhaUttanasana().build();
    }
}
