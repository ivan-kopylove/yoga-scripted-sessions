package com.github.lazyf1sh.asanas.named.kapalabhati;

import com.github.lazyf1sh.asanas.Asana;
import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;

public class Kapalabhati extends Asana
{

    private Kapalabhati()
    {
    }

    public static SourceFile kapalabhati() throws IOException
    {
        return new Kapalabhati().build();
    }
}
