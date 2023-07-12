package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.github.lazyf1sh.nodes.ardhaUttanasana.ArdhaUttanasana.ardhaUttanasana;
import static com.github.lazyf1sh.nodes.ashtangaNamaskara.AshtangaNamaskara.ashtangaNamaskara;
import static com.github.lazyf1sh.nodes.danayamanaDhanurasana.DanayamanaDhanurasana.danayamanaDhanurasana;
import static com.github.lazyf1sh.nodes.dhanurasana.Dhanurasana.dhanurasana;
import static com.github.lazyf1sh.nodes.ekaPadaKaundiniAsanaSecondRightLeg.EkaPadaKaundiniAsanaSecond.ekaPadaKaundiniAsanaSecond;
import static com.github.lazyf1sh.nodes.makarasana.Makarasana.makarasana;
import static com.github.lazyf1sh.nodes.shalabhasana.Shalabhasana.shalabhasana;
import static com.github.lazyf1sh.nodes.unnamed.a8189182f2e4Left.A8189182f2e4Left.a8189182f2e4Left;
import static com.github.lazyf1sh.nodes.unnamed.a8189182f2e4Right.A8189182f2e4Right.a8189182f2e4Right;
import static com.github.lazyf1sh.nodes.unnamed.a9c46dc25b049.A9c46dc25b04.a9c46dc25b04;
import static com.github.lazyf1sh.nodes.unnamed.adf790583a2b.Adf790583a2b.adf790583a2b;
import static com.github.lazyf1sh.nodes.unnamed.b01ed0397b45.B01ed0397b45.b01ed0397b45;
import static com.github.lazyf1sh.nodes.unnamed.bda5244496ee.Bda5244496ee.bda5244496ee;
import static com.github.lazyf1sh.nodes.unnamed.e8ab2e5f8cba.E8ab2e5f8cba.e8ab2e5f8cba;
import static com.github.lazyf1sh.nodes.unnamed.ed7c24b3de79.Ed7c24b3de79.ed7c24b3de79;
import static com.github.lazyf1sh.nodes.urdhvaHastasana.UrdhvaHastasanaOnTipToes.urdhvaHastasanaOnTipToes;
import static com.github.lazyf1sh.nodes.vasisthasana.VasisthasanaLegsCrossed.vasisthasanaLegsCrossed;
import static com.github.lazyf1sh.nodes.vasisthasana.VasisthasanaLegsExtended.vasisthasanaLegExtended;
import static com.github.lazyf1sh.transitions.a0cdcbfb6458d.a0cdcbfb6458d;
import static com.github.lazyf1sh.transitions.a44d66e4c4b2d.a44d66e4c4b2d;
import static com.github.lazyf1sh.transitions.a7e9edc7a803b.a7e9edc7a803b;
import static com.github.lazyf1sh.transitions.a9a6e36fef02.a9a6e36fef02;
import static com.github.lazyf1sh.transitions.d3520675899a.d3520675899a;
import static com.github.lazyf1sh.transitions.d6054818ad4b.d6054818ad4b;
import static com.github.lazyf1sh.transitions.f2238bca3e1b.f2238bca3e1b;

public class Bends implements Suite
{

    public static List<SourceFile> bends() throws IOException
    {
        return new Bends().build();
    }

    public List<SourceFile> build() throws IOException
    {
        final List<SourceFile> result = new ArrayList<>();

        result.add(urdhvaHastasanaOnTipToes());
        result.add(f2238bca3e1b());
        result.add(d6054818ad4b());
        result.add(ardhaUttanasana());
        result.add(d3520675899a());
        result.add(a0cdcbfb6458d());
        result.add(danayamanaDhanurasana());
        result.add(ed7c24b3de79());
        result.add(e8ab2e5f8cba());
        result.add(a8189182f2e4Right());
        result.add(ekaPadaKaundiniAsanaSecond());
        result.add(a9c46dc25b04());
        result.add(vasisthasanaLegsCrossed());
        result.add(vasisthasanaLegExtended());
        result.add(a9a6e36fef02());
        result.add(dhanurasana());
        result.add(a7e9edc7a803b());
        result.add(shalabhasana());
        result.add(makarasana());
        result.add(a44d66e4c4b2d());
        result.add(ashtangaNamaskara());
        result.add(adf790583a2b());
        result.add(a8189182f2e4Left());
        result.add(ekaPadaKaundiniAsanaSecond());
        result.add(bda5244496ee());
        result.add(makarasana());
        result.add(b01ed0397b45());

        return result;
    }
}
