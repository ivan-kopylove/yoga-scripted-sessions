package com.github.lazyf1sh.asanas.named;

import com.github.lazyf1sh.asanas.Asana;
import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;

public class Requisite extends Asana
{

    private Requisite()
    {

    }

    public static SourceFile requisite() throws IOException
    {
        return new Requisite().build();
    }
}