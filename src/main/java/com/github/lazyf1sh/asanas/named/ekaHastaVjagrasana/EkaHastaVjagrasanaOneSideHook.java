package com.github.lazyf1sh.asanas.named.ekaHastaVjagrasana;

import com.github.lazyf1sh.asanas.Asana;
import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;

public class EkaHastaVjagrasanaOneSideHook extends Asana
{

    private EkaHastaVjagrasanaOneSideHook()
    {
        super();
    }

    public static SourceFile ekaHastaVjagrasanaOneSideHook() throws IOException
    {
        return new EkaHastaVjagrasanaOneSideHook().build();
    }
}
