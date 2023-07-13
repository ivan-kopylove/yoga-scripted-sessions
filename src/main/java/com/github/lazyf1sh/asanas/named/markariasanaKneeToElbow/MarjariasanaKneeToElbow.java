package com.github.lazyf1sh.asanas.named.markariasanaKneeToElbow;

import com.github.lazyf1sh.asanas.Asana;
import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;

public class MarjariasanaKneeToElbow extends Asana
{

    private MarjariasanaKneeToElbow()
    {
    }

    public static SourceFile marjariasanaKneeToElbow() throws IOException
    {
        return new MarjariasanaKneeToElbow().build();
    }
}
