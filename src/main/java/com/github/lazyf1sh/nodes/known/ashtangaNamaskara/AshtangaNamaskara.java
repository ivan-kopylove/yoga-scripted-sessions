package com.github.lazyf1sh.nodes.known.ashtangaNamaskara;

import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.nodes.Asana;

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
