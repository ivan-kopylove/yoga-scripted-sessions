package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.nodes.shalabhasana.Shalabhasana;
import com.github.lazyf1sh.transitions.*;
import com.github.lazyf1sh.yandex.speech.api.Voice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.github.lazyf1sh.nodes.ardhaUttanasana.ArdhaUttanasana.ardhaUttanasana;
import static com.github.lazyf1sh.nodes.ashtangaNamaskara.AshtangaNamaskara.ashtangaNamaskara;
import static com.github.lazyf1sh.nodes.danayamanaDhanurasana.DanayamanaDhanurasana.danayamanaDhanurasana;
import static com.github.lazyf1sh.nodes.dhanurasana.Dhanurasana.dhanurasana;
import static com.github.lazyf1sh.nodes.ekaPadaKaundiniAsanaSecondRightLeg.EkaPadaKaundiniAsanaSecond.ekaPadaKaundiniAsanaSecond;
import static com.github.lazyf1sh.nodes.makarasana.Makarasana.makarasana;
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
import static com.github.lazyf1sh.suits.SwitchVoice.randomRuVoice;
import static com.github.lazyf1sh.suits.SwitchVoice.switchVoice;
import static com.github.lazyf1sh.yandex.speech.api.Voice.ERMIL;

@SuppressWarnings("StringBufferReplaceableByString")
public class Bends implements Suite
{

    public static List<SourceFile> bends() throws IOException
    {
        return new Bends().build();
    }

    public List<SourceFile> build() throws IOException
    {
        final List<SourceFile> result = new ArrayList<>();

        Voice bendsMainVoice = ERMIL;


        result.add(switchVoice(bendsMainVoice));
        result.add(urdhvaHastasanaOnTipToes());
        result.add(new Unnamed_f2238bca3e1b().build());
        result.add(new Unnamed_d6054818ad4b().build());
        result.add(ardhaUttanasana());
        result.add(new Unnamed_d3520675899a().build());
        result.add(new Unnamed_0cdcbfb6458d().build());
        result.add(danayamanaDhanurasana());
        result.add(ed7c24b3de79());
        result.add(e8ab2e5f8cba());
        result.add(a8189182f2e4Right());
        result.add(ekaPadaKaundiniAsanaSecond());
        result.add(a9c46dc25b04());
        result.add(randomRuVoice());
        result.add(vasisthasanaLegsCrossed());
        result.add(randomRuVoice());
        result.add(vasisthasanaLegExtended());
        result.add(randomRuVoice());
        result.add(new Unnamed_a9a6e36fef02().build());
        result.add(randomRuVoice());
        result.add(dhanurasana());
        result.add(randomRuVoice());
        result.add(new Unnamed_7e9edc7a803b().build());
        result.add(randomRuVoice());
        result.add(new Shalabhasana().build());
        result.add(randomRuVoice());
        result.add(makarasana());
        result.add(switchVoice(bendsMainVoice));
        result.add(new Unnamed_44d66e4c4b2d().build());
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
