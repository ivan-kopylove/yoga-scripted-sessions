package com.github.lazyf1sh.asanas.named.commonWarump;

import com.github.lazyf1sh.asanas.named.ardhaUttanasana.ArdhaUttanasana;
import com.github.lazyf1sh.asanas.named.ashtangaNamaskara.AshtangaNamaskara;
import com.github.lazyf1sh.asanas.named.balasana.Balasana;
import com.github.lazyf1sh.asanas.named.bitilasana.Bitilasana;
import com.github.lazyf1sh.asanas.named.bitilasana.makarasana.Makarasana;
import com.github.lazyf1sh.asanas.named.danayamanaDhanurasana.DanayamanaDhanurasana;
import com.github.lazyf1sh.asanas.named.dhanurasana.Dhanurasana;
import com.github.lazyf1sh.asanas.named.ekaPadaKaundiniAsanaSecondRightLeg.EkaPadaKaundiniAsanaSecond;
import com.github.lazyf1sh.asanas.named.marjariasana.Marjariasana;
import com.github.lazyf1sh.asanas.named.marjariasana.MarjariasanaKneeToForehead;
import com.github.lazyf1sh.asanas.named.shalabhasana.Shalabhasana;
import com.github.lazyf1sh.asanas.named.suptaVirasana.SuptaVirasana;
import com.github.lazyf1sh.asanas.named.tadasana.TadasanaPalmsInNamaste;
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

public class CommonWarmup implements Suite {

    public List<SourceFile> build() throws IOException {
        List<SourceFile> list = List.of(
                        TadasanaPalmsInNamaste.class,
                        a7d8c46afd699.class,
                        Balasana.class,
                        t3ebc07c8470b.class,
                        Bitilasana.class,
                        Marjariasana.class,
                        Bitilasana.class,
                        Marjariasana.class,
                        MarjariasanaKneeToForehead.class,
                        CommonWarmup.class
                )
                .stream()
                .map(clazz -> readConventionalWayTxt(clazz))
                .toList();




        return list;
    }
}
