package com.github.lazyf1sh.nodes.named.ekaPadaKaundiniAsanaSecondRightLeg;

import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.nodes.Asana;

import java.io.IOException;

public class EkaPadaKaundiniAsanaSecond extends Asana
{

    private EkaPadaKaundiniAsanaSecond()
    {
        super();
    }

    public static SourceFile ekaPadaKaundiniAsanaSecond() throws IOException
    {
        return new EkaPadaKaundiniAsanaSecond().build();
    }
}
