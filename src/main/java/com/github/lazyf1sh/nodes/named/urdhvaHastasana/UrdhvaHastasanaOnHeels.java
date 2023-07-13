package com.github.lazyf1sh.nodes.named.urdhvaHastasana;

import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.nodes.Asana;

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
