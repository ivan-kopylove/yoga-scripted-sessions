package com.github.lazyf1sh.asanas.named.danayamanaDhanurasana;

import com.github.lazyf1sh.asanas.Asana;
import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;

public class DanayamanaDhanurasana extends Asana
{

    private DanayamanaDhanurasana()
    {
    }

    public static SourceFile danayamanaDhanurasana() throws IOException
    {
        return new DanayamanaDhanurasana().build();
    }
}
