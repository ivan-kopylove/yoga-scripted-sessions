package com.github.lazyf1sh.asanas.named.tadasana;

import com.github.lazyf1sh.asanas.Asana;
import com.github.lazyf1sh.domain.SourceFile;

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
