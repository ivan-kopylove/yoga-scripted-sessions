package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.github.lazyf1sh.nodes.urdhvaHastasana.UrdhvaHastasanaOnTipToes.urdhvaHastasanaOnTipToes;
import static com.github.lazyf1sh.transitions.GenericTransition.genericTransition;
import static com.github.lazyf1sh.transitions.Unnamed_f2238bca3e1b.f2238bca3e1b;
import static com.github.lazyf1sh.util.ReadAsanaParams.readAsanaParams;
import static com.github.lazyf1sh.util.Util.readConventionalWay;

public class HipsOpening implements Suite
{

    @Override
    public List<SourceFile> build() throws IOException
    {
        final List<SourceFile> result = new ArrayList<>();


        result.add(urdhvaHastasanaOnTipToes());
        result.add(f2238bca3e1b());
        result.add(genericTransition(Paths.get("ad96a996f0ca")));
        result.add(readConventionalWay(readAsanaParams().resourceBundleClass(HipsOpening.class)));

        return result;
    }
}
