package com.github.lazyf1sh.asanas.named.dolphin;

import com.github.lazyf1sh.asanas.Asana;
import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;

public class Dolphin extends Asana
{

    private Dolphin()
    {

    }

    public static SourceFile dolphin() throws IOException
    {
        return new Dolphin().build();
    }
}
