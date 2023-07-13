package com.github.lazyf1sh.asanas.named.bigToeToEar;

import com.github.lazyf1sh.asanas.Asana;
import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;

public class BigToeToEar extends Asana
{

    private BigToeToEar()
    {

    }

    public static SourceFile bigToeToEar() throws IOException
    {
        return new BigToeToEar().build();
    }
}
