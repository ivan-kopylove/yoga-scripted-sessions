package com.github.lazyf1sh.asanas.named.hastauttanasana;

import com.github.lazyf1sh.asanas.Asana;
import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;

public class HastaUttanasana extends Asana
{

    private HastaUttanasana()
    {

    }

    public static SourceFile hastaUttanasana() throws IOException
    {
        return new HastaUttanasana().build();
    }
}
