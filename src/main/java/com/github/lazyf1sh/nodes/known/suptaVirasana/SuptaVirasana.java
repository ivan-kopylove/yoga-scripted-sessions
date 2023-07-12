package com.github.lazyf1sh.nodes.known.suptaVirasana;

import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.nodes.Asana;

import java.io.IOException;

public class SuptaVirasana extends Asana
{

    public static SourceFile suptaVirasana() throws IOException
    {
        return new SuptaVirasana().build();
    }
}
