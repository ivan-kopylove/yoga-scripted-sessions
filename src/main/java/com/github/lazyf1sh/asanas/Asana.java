package com.github.lazyf1sh.asanas;

import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;

import static com.github.lazyf1sh.domain.ReadAsanaParams.readAsanaParams;
import static com.github.lazyf1sh.util.Util.readConventionalWayTxt;

public abstract class Asana
{

    protected Asana()
    {

    }

    public SourceFile build() throws IOException
    {
        return readConventionalWayTxt(readAsanaParams().resourceBundleClass(this.getClass()));
    }
}
