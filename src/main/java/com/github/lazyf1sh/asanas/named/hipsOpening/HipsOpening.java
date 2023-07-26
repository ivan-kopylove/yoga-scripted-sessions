package com.github.lazyf1sh.asanas.named.hipsOpening;

import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.domain.Suite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.github.lazyf1sh.asanas.named.hipsOpening.t56d9f0f24569.t56d9f0f24569;
import static com.github.lazyf1sh.asanas.named.urdhvaHastasana.UrdhvaHastasanaOnTipToes.urdhvaHastasanaOnTipToes;
import static com.github.lazyf1sh.asanas.unnamed.ad96a996f0ca.ad96a996f0ca;
import static com.github.lazyf1sh.asanas.unnamed.f2238bca3e1b.f2238bca3e1b;
import static com.github.lazyf1sh.domain.ReadAsanaParams.readAsanaParams;
import static com.github.lazyf1sh.util.Util.readConventionalWay;

public class HipsOpening implements Suite
{

    @Override
    public List<SourceFile> build() throws IOException
    {
        List<SourceFile> result = new ArrayList<>();


        result.add(urdhvaHastasanaOnTipToes());
        result.add(f2238bca3e1b());
        result.add(ad96a996f0ca());
        result.add(readConventionalWay(readAsanaParams().resourceBundleClass(HipsOpening.class)));
        result.add(t56d9f0f24569());

        return result;
    }
}
