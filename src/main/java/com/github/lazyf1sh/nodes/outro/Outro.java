package com.github.lazyf1sh.nodes.outro;

import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;

import static com.github.lazyf1sh.util.ReadAsanaParams.readAsanaParams;
import static com.github.lazyf1sh.util.Util.readConventionalWay;

public class Outro
{

    public SourceFile build() throws IOException
    {
        return readConventionalWay(readAsanaParams().resourceBundleClass(this.getClass()));
    }
}
