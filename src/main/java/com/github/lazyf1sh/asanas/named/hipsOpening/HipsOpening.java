package com.github.lazyf1sh.asanas.named.hipsOpening;

import com.github.lazyf1sh.asanas.named.ardhaUttanasana.ArdhaUttanasana;
import com.github.lazyf1sh.asanas.named.ashtangaNamaskara.AshtangaNamaskara;
import com.github.lazyf1sh.asanas.named.bitilasana.makarasana.Makarasana;
import com.github.lazyf1sh.asanas.named.danayamanaDhanurasana.DanayamanaDhanurasana;
import com.github.lazyf1sh.asanas.named.dhanurasana.Dhanurasana;
import com.github.lazyf1sh.asanas.named.ekaPadaKaundiniAsanaSecondRightLeg.EkaPadaKaundiniAsanaSecond;
import com.github.lazyf1sh.asanas.named.shalabhasana.Shalabhasana;
import com.github.lazyf1sh.asanas.named.suptaVirasana.SuptaVirasana;
import com.github.lazyf1sh.asanas.named.urdhvaHastasana.UrdhvaHastasanaOnTipToes;
import com.github.lazyf1sh.asanas.named.vasisthasana.VasisthasanaLegsCrossed;
import com.github.lazyf1sh.asanas.named.vasisthasana.VasisthasanaLegsExtended;
import com.github.lazyf1sh.asanas.unnamed.*;
import com.github.lazyf1sh.asanas.unnamed.a8189182f2e4.A8189182f2e4;
import com.github.lazyf1sh.asanas.unnamed.a8189182f2e4Right.A8189182f2e4Right;
import com.github.lazyf1sh.asanas.unnamed.a9c46dc25b049.A9c46dc25b04;
import com.github.lazyf1sh.asanas.unnamed.adf790583a2b.b71c565047f6;
import com.github.lazyf1sh.asanas.unnamed.adf790583a2b.b72e399d645e;
import com.github.lazyf1sh.asanas.unnamed.adf790583a2b.bc707331e557;
import com.github.lazyf1sh.asanas.unnamed.b01ed0397b45.B01ed0397b45;
import com.github.lazyf1sh.asanas.unnamed.bda5244496ee.Bda5244496ee;
import com.github.lazyf1sh.asanas.unnamed.e8ab2e5f8cba.E8ab2e5f8cba;
import com.github.lazyf1sh.asanas.unnamed.ed7c24b3de79.Ed7c24b3de79;
import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.domain.Suite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.github.lazyf1sh.domain.ReadAsanaParams.readAsanaParams;
import static com.github.lazyf1sh.util.Util.readConventionalWayTxt;

public class HipsOpening implements Suite {

    @Override
    public List<SourceFile> build() throws IOException {
        List<SourceFile> result = List.of(
                        UrdhvaHastasanaOnTipToes.class,
                        f2238bca3e1b.class,
                        ad96a996f0ca.class,
                        HipsOpening.class,
                        t56d9f0f24569.class

                )
                .stream()
                .map(clazz -> readConventionalWayTxt(clazz))
                .toList();


        return result;
    }
}
