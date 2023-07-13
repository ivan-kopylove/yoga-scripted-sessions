package com.github.lazyf1sh.nodes.named.agnisarKriya;

import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.nodes.Asana;

import java.io.IOException;

public class AgnisarKriya extends Asana
{

    private AgnisarKriya()
    {

    }

    public static SourceFile agnisarKriya() throws IOException
    {
        return new AgnisarKriya().build();
    }
}
