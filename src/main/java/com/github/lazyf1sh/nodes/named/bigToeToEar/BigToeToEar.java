package com.github.lazyf1sh.nodes.named.bigToeToEar;

import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.nodes.Asana;

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
