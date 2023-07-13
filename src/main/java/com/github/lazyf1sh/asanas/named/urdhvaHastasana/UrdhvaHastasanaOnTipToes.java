package com.github.lazyf1sh.asanas.named.urdhvaHastasana;

import com.github.lazyf1sh.asanas.Asana;
import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;

public class UrdhvaHastasanaOnTipToes extends Asana
{

    private UrdhvaHastasanaOnTipToes()
    {

    }

    public static SourceFile urdhvaHastasanaOnTipToes() throws IOException
    {
        return new UrdhvaHastasanaOnTipToes().build();
    }
}
