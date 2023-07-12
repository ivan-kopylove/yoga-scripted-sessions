package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.github.lazyf1sh.nodes.known.ardhaUttanasana.ArdhaUttanasana.ardhaUttanasana;
import static com.github.lazyf1sh.nodes.known.ashtangaNamaskara.AshtangaNamaskara.ashtangaNamaskara;
import static com.github.lazyf1sh.nodes.known.bitilasana.makarasana.Makarasana.makarasana;
import static com.github.lazyf1sh.nodes.known.danayamanaDhanurasana.DanayamanaDhanurasana.danayamanaDhanurasana;
import static com.github.lazyf1sh.nodes.known.dhanurasana.Dhanurasana.dhanurasana;
import static com.github.lazyf1sh.nodes.known.ekaPadaKaundiniAsanaSecondRightLeg.EkaPadaKaundiniAsanaSecond.ekaPadaKaundiniAsanaSecond;
import static com.github.lazyf1sh.nodes.known.shalabhasana.Shalabhasana.shalabhasana;
import static com.github.lazyf1sh.nodes.known.urdhvaHastasana.UrdhvaHastasanaOnTipToes.urdhvaHastasanaOnTipToes;
import static com.github.lazyf1sh.nodes.known.vasisthasana.VasisthasanaLegsCrossed.vasisthasanaLegsCrossed;
import static com.github.lazyf1sh.nodes.known.vasisthasana.VasisthasanaLegsExtended.vasisthasanaLegExtended;
import static com.github.lazyf1sh.nodes.unnamed.GarudaAsana.garudaAsana;
import static com.github.lazyf1sh.nodes.unnamed.a0cdcbfb6458d.a0cdcbfb6458d;
import static com.github.lazyf1sh.nodes.unnamed.a44d66e4c4b2d.a44d66e4c4b2d;
import static com.github.lazyf1sh.nodes.unnamed.a7e9edc7a803b.a7e9edc7a803b;
import static com.github.lazyf1sh.nodes.unnamed.a8189182f2e4Left.A8189182f2e4Left.a8189182f2e4Left;
import static com.github.lazyf1sh.nodes.unnamed.a8189182f2e4Right.A8189182f2e4Right.a8189182f2e4Right;
import static com.github.lazyf1sh.nodes.unnamed.a9a6e36fef02.a9a6e36fef02;
import static com.github.lazyf1sh.nodes.unnamed.a9c46dc25b049.A9c46dc25b04.a9c46dc25b04;
import static com.github.lazyf1sh.nodes.unnamed.adf790583a2b.SuptaVirasana.suptaVirasana;
import static com.github.lazyf1sh.nodes.unnamed.adf790583a2b.b71c565047f6.b71c565047f6;
import static com.github.lazyf1sh.nodes.unnamed.adf790583a2b.bc707331e557.bc707331e557;
import static com.github.lazyf1sh.nodes.unnamed.b01ed0397b45.B01ed0397b45.b01ed0397b45;
import static com.github.lazyf1sh.nodes.unnamed.bda5244496ee.Bda5244496ee.bda5244496ee;
import static com.github.lazyf1sh.nodes.unnamed.d3520675899a.d3520675899a;
import static com.github.lazyf1sh.nodes.unnamed.d6054818ad4b.d6054818ad4b;
import static com.github.lazyf1sh.nodes.unnamed.e8ab2e5f8cba.E8ab2e5f8cba.e8ab2e5f8cba;
import static com.github.lazyf1sh.nodes.unnamed.ed7c24b3de79.Ed7c24b3de79.ed7c24b3de79;
import static com.github.lazyf1sh.nodes.unnamed.f2238bca3e1b.f2238bca3e1b;
import static com.github.lazyf1sh.nodes.unnamed.fefbfc639f07.fefbfc639f07;
import static com.github.lazyf1sh.nodes.unnamed.t1007415d99d8.t1007415d99d8;

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
        result.add(fefbfc639f07());
        result.add(garudaAsana());
        result.add(t1007415d99d8());
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
        result.add(b71c565047f6());
        result.add(suptaVirasana());
        result.add(bc707331e557());
        result.add(a8189182f2e4Left());
        result.add(ekaPadaKaundiniAsanaSecond());
        result.add(bda5244496ee());
        result.add(makarasana());
        result.add(b01ed0397b45());

        return result;
    }
}
