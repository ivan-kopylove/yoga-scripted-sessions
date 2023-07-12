package com.github.lazyf1sh.nodes.known.danayamanaDhanurasana;

import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.nodes.Asana;

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
