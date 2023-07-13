package com.github.lazyf1sh.nodes.named.tadasana;

import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.nodes.Asana;

import java.io.IOException;

public class TadasanaPalmsInNamaste extends Asana
{

    private TadasanaPalmsInNamaste()
    {

    }

    public static SourceFile tadasanaPalmsInNamaste() throws IOException
    {
        return new TadasanaPalmsInNamaste().build();
    }
}
