package com.github.lazyf1sh.nodes.named.urdhvaHastasana;

import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.nodes.Asana;

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
