package com.github.lazyf1sh.asanas.named;

import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.domain.Suite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.github.lazyf1sh.asanas.named.adhoc.AdHoc.adHoc;

public class AdHoc implements Suite
{

    public List<SourceFile> build() throws IOException
    {
        List<SourceFile> result = new ArrayList<>();

        result.add(adHoc());

        return result;
    }
}
