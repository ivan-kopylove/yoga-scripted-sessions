package com.github.lazyf1sh.asanas.named.suptaVirasana;

import com.github.lazyf1sh.asanas.Asana;
import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;

public class SuptaVirasana extends Asana
{

    public static SourceFile suptaVirasana() throws IOException
    {
        return new SuptaVirasana().build();
    }
}
