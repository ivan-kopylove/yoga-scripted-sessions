package com.github.lazyf1sh.asanas.named.urdhvaHastasana;

import com.github.lazyf1sh.asanas.Asana;
import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;

public class UrdhvaHastasanaOnHeels extends Asana
{

    private UrdhvaHastasanaOnHeels()
    {

    }

    public static SourceFile urdhvaHastasanaOnHeels() throws IOException
    {
        return new UrdhvaHastasanaOnHeels().build();
    }
}
