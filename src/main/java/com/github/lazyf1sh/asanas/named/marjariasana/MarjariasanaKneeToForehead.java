package com.github.lazyf1sh.asanas.named.marjariasana;

import com.github.lazyf1sh.asanas.Asana;
import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;

public class MarjariasanaKneeToForehead extends Asana
{

    private MarjariasanaKneeToForehead()
    {
    }

    public static SourceFile marjariasanaKneeToForehead() throws IOException
    {
        return new MarjariasanaKneeToForehead().build();
    }
}
