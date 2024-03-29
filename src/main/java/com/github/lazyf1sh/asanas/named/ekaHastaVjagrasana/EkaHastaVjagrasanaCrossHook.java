package com.github.lazyf1sh.asanas.named.ekaHastaVjagrasana;

import com.github.lazyf1sh.asanas.Asana;
import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;

public class EkaHastaVjagrasanaCrossHook extends Asana
{

    private EkaHastaVjagrasanaCrossHook()
    {
        super();
    }

    public static SourceFile ekaHastaVjagrasanaCrossHook() throws IOException
    {
        return new EkaHastaVjagrasanaCrossHook().build();
    }
}
