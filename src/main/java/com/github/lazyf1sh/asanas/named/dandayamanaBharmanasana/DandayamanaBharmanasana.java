package com.github.lazyf1sh.asanas.named.dandayamanaBharmanasana;

import com.github.lazyf1sh.asanas.Asana;
import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;

public class DandayamanaBharmanasana extends Asana
{
    private DandayamanaBharmanasana()
    {
        super();
    }

    public static SourceFile dandayamanaBharmanasana() throws IOException
    {
        return new DandayamanaBharmanasana().build();
    }
}
