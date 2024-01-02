package com.github.lazyf1sh.asanas.named.adhoc;

import com.github.lazyf1sh.asanas.Asana;
import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;

public class AdHoc extends Asana
{

    private AdHoc()
    {
        super();
    }

    public static SourceFile adHoc() throws IOException
    {
        return new AdHoc().build();
    }
}
