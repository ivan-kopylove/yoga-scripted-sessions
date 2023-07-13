package com.github.lazyf1sh.nodes.named.shalabhasana;

import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.nodes.Asana;

import java.io.IOException;

public class Shalabhasana extends Asana
{

    private Shalabhasana()
    {
    }

    public static SourceFile shalabhasana() throws IOException
    {
        return new Shalabhasana().build();
    }
}
