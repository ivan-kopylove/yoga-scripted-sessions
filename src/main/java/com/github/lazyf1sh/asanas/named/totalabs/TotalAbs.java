package com.github.lazyf1sh.asanas.named.totalabs;

import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.domain.Suite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.github.lazyf1sh.domain.ReadAsanaParams.readAsanaParams;
import static com.github.lazyf1sh.util.Util.readConventionalWayTxt;

public class TotalAbs implements Suite
{
    @Override
    public List<SourceFile> build() throws IOException
    {
        List<SourceFile> result = new ArrayList<>();

        result.add(readConventionalWayTxt(readAsanaParams().resourceBundleClass(this.getClass())));

        return result;
    }
}
