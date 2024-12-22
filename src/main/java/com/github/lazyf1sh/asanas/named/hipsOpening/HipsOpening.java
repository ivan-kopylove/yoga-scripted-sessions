package com.github.lazyf1sh.asanas.named.hipsOpening;

import com.github.lazyf1sh.asanas.named.urdhvaHastasana.UrdhvaHastasanaOnTipToes;
import com.github.lazyf1sh.asanas.unnamed.*;
import com.github.lazyf1sh.domain.Suite;

import java.io.IOException;
import java.util.List;


public class HipsOpening implements Suite {

    @Override
    public List<Class<?>> build() throws IOException {
        return List.of(
                UrdhvaHastasanaOnTipToes.class,
                f2238bca3e1b.class,
                ad96a996f0ca.class,
                HipsOpening.class,
                t56d9f0f24569.class

        );
    }
}
