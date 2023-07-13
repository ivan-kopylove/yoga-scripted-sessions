package com.github.lazyf1sh.nodes.named.balasana;

import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.nodes.Asana;

import java.io.IOException;

public class Balasana extends Asana
{

    private Balasana()
    {

    }

    public static SourceFile balasana() throws IOException
    {
        return new Balasana().build();
    }
}
