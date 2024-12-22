package com.github.lazyf1sh.asanas.named;

import com.github.lazyf1sh.asanas.named.agnisarKriya.AgnisarKriya;
import com.github.lazyf1sh.asanas.named.ardhaUttanasanaWithStandingPoint.ArdhaUttanasanaWithStandingPoint;
import com.github.lazyf1sh.asanas.named.bigToeToEar.BigToeToEar;
import com.github.lazyf1sh.asanas.named.bitilasana.Bitilasana;
import com.github.lazyf1sh.asanas.named.dandayamanaBharmanasana.DandayamanaBharmanasana;
import com.github.lazyf1sh.asanas.named.dolphin.Dolphin;
import com.github.lazyf1sh.asanas.named.ekaHastaVjagrasana.EkaHastaVjagrasanaCrossHook;
import com.github.lazyf1sh.asanas.named.ekaHastaVjagrasana.EkaHastaVjagrasanaOneSideHook;
import com.github.lazyf1sh.asanas.named.ekaPadaKaundiniAsanaSecondRightLeg.EkaPadaKaundiniAsanaSecond;
import com.github.lazyf1sh.asanas.named.kapalabhati.Kapalabhati;
import com.github.lazyf1sh.asanas.named.markariasanaKneeToElbow.MarjariasanaKneeToElbow;
import com.github.lazyf1sh.asanas.named.rotateKneeOutwards.RotateKneeOutwards;
import com.github.lazyf1sh.asanas.named.sideLegSpring.SideLegSpring;
import com.github.lazyf1sh.asanas.named.suptaVirasana.SuptaVirasana;
import com.github.lazyf1sh.asanas.named.suryaNamaskar.SuryaNamaskarRound01;
import com.github.lazyf1sh.asanas.named.suryaNamaskar.SuryaNamaskarRound02;
import com.github.lazyf1sh.asanas.named.suryaNamaskar.SuryaNamaskarRound03;
import com.github.lazyf1sh.asanas.named.suryaNamaskar.SuryaNamaskarSides;
import com.github.lazyf1sh.asanas.named.tadasana.Tadasana;
import com.github.lazyf1sh.asanas.named.urdhvaHastasana.UrdhvaHastasanaOnHeels;
import com.github.lazyf1sh.asanas.named.urdhvaHastasana.UrdhvaHastasanaOnTipToes;
import com.github.lazyf1sh.asanas.unnamed.*;
import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.domain.Suite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.github.lazyf1sh.util.Util.readConventionalWayTxt;

public class SuryaNamaskar implements Suite {


    public List<SourceFile> build() throws IOException {
        List<SourceFile> result = new ArrayList<>();

        List.of(
                        UrdhvaHastasanaOnTipToes.class,
                        UrdhvaHastasanaOnHeels.class,
                        t2acd3f67e8ed.class,
                        SuryaNamaskarRound01.class,
                        Tadasana.class,
                        SuryaNamaskarRound02.class,
                        SuryaNamaskarRound03.class,
                        ArdhaUttanasanaWithStandingPoint.class,
                        Kapalabhati.class,
                        AgnisarKriya.class,
                        d41ec8988cb2.class,
                        Bitilasana.class,
                        MarjariasanaKneeToElbow.class,
                        DandayamanaBharmanasana.class,
                        EkaHastaVjagrasanaCrossHook.class,
                        EkaPadaKaundiniAsanaSecond.class,
                        ef2eb0af2276.class,
                        Dolphin.class,
                        b21ef52bd090.class,
                        SideLegSpring.class,
                        t266ae7aacbff.class,
                        RotateKneeOutwards.class,
                        d856222abcd5.class,
                        BigToeToEar.class,
                        EkaHastaVjagrasanaOneSideHook.class,
                        b5330ada6870.class,
                        b9570a4275e4.class,
                        SuptaVirasana.class,
                        SuryaNamaskarSides.class
                )
                .stream()
                .map(clazz -> readConventionalWayTxt(clazz))
                .toList();


        return result;
    }
}
