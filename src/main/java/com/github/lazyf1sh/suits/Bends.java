
package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.nodes.shalabhasana.Shalabhasana;
import com.github.lazyf1sh.nodes.urdhvaHastasana.UrdhvaHastasana;
import com.github.lazyf1sh.transitions.*;

import java.io.IOException;

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
import static com.github.lazyf1sh.nodes.vasisthasana.VasisthasanaLegsCrossed.vasisthasanaLegsCrossed;
import static com.github.lazyf1sh.nodes.vasisthasana.VasisthasanaLegsExtended.vasisthasanaLegExtended;

@SuppressWarnings("StringBufferReplaceableByString")
public class Bends {
    private Bends() {

    }

    public static String bends() throws IOException {
        return new Bends().build();
    }

    private String build() throws IOException {
        final StringBuilder result = new StringBuilder();


        result.append(new UrdhvaHastasana().urdhvaHastasanaOnTiptoes());
        result.append(new Unnamed_f2238bca3e1b().build());
        result.append(new Unnamed_d6054818ad4b().build());
        result.append(ardhaUttanasana());
        result.append(new Unnamed_d3520675899a().build());
        result.append(new Unnamed_0cdcbfb6458d().build());
        result.append(danayamanaDhanurasana());
        result.append(ed7c24b3de79());
        result.append(e8ab2e5f8cba());
        result.append(a8189182f2e4Right());
        result.append(ekaPadaKaundiniAsanaSecond());
        result.append(a9c46dc25b04());
        result.append(vasisthasanaLegsCrossed());
        result.append(vasisthasanaLegExtended());
        result.append(new Unnamed_a9a6e36fef02().build());
        result.append(dhanurasana());
        result.append(new Unnamed_7e9edc7a803b().build());
        result.append(new Shalabhasana().build());
        result.append(makarasana());
        result.append(new Unnamed_44d66e4c4b2d().build());
        result.append(ashtangaNamaskara());
        result.append(adf790583a2b());
        result.append(a8189182f2e4Left());
        result.append(ekaPadaKaundiniAsanaSecond());
        result.append(bda5244496ee());
        result.append(makarasana());
        result.append(b01ed0397b45());
        result.append(new Outro().build());
        result.append("\n");

        return result.toString();
    }
}
