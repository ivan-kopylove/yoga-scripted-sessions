package com.github.lazyf1sh.asanas.named.ashtangaNamaskara;

import com.github.lazyf1sh.asanas.Asana;
import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;

public class AshtangaNamaskara extends Asana
{

    private AshtangaNamaskara()
    {
        super();
    }

    public static SourceFile ashtangaNamaskara() throws IOException
    {
        return new AshtangaNamaskara().build();
    }
}
