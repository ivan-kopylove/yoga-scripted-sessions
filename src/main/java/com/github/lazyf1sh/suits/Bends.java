
package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.nodes.ardhaUttanasana.ArdhaUttanasana;
import com.github.lazyf1sh.nodes.makarasana.Makarasana;
import com.github.lazyf1sh.nodes.shalabhasana.Shalabhasana;
import com.github.lazyf1sh.nodes.unnamed.a1e3f720bd3d.A1e3f720bd3d;
import com.github.lazyf1sh.nodes.unnamed.ffbf000cd2c.Ffbf000cd2c;
import com.github.lazyf1sh.nodes.urdhvaHastasana.UrdhvaHastasana;
import com.github.lazyf1sh.nodes.vasisthasana.Vasisthasana;
import com.github.lazyf1sh.transitions.*;


import java.io.IOException;

import static com.github.lazyf1sh.nodes.ashtangaNamaskara.AshtangaNamaskara.ashtangaNamaskara;
import static com.github.lazyf1sh.nodes.danayamanaDhanurasana.DanayamanaDhanurasana.danayamanaDhanurasana;
import static com.github.lazyf1sh.nodes.dhanurasana.Dhanurasana.dhanurasana;
import static com.github.lazyf1sh.nodes.ekaPadaKaundiniAsanaSecond.EkaPadaKaundiniAsanaSecond.ekaPadaKaundiniAsanaSecond;
import static com.github.lazyf1sh.nodes.unnamed.a1e3f720bd3d.A1e3f720bd3d.a1e3f720bd3d;
import static com.github.lazyf1sh.nodes.unnamed.adf790583a2b.Adf790583a2b.adf790583a2b;
import static com.github.lazyf1sh.nodes.unnamed.b01ed0397b45.B01ed0397b45.b01ed0397b45;
import static com.github.lazyf1sh.nodes.unnamed.bda5244496ee.Bda5244496ee.bda5244496ee;
import static com.github.lazyf1sh.nodes.unnamed.e8ab2e5f8cba.E8ab2e5f8cba.e8ab2e5f8cba;
import static com.github.lazyf1sh.nodes.unnamed.a9c46dc25b049.A9c46dc25b04.a9c46dc25b04;
import static com.github.lazyf1sh.nodes.unnamed.ed7c24b3de79.Ed7c24b3de79.ed7c24b3de79;
import static com.github.lazyf1sh.nodes.unnamed.ffbf000cd2c.Ffbf000cd2c.ffbf000cd2c;
import static com.github.lazyf1sh.util.Util.readFile;

@SuppressWarnings("StringBufferReplaceableByString")
public class Bends {
    private Bends() {

    }

    public static String bends() throws IOException {
        return new Bends().build();
    }

    private String build() throws IOException {
        final StringBuilder result = new StringBuilder();


        result.append("\n");
        result.append(new Disclaimer().build());
        result.append(new CommonIntro().build());
        result.append(new UrdhvaHastasana().urdhvaHastasanaOnTiptoes());
        result.append(new Unnamed_f2238bca3e1b().build());
        result.append(new Unnamed_d6054818ad4b().build());
        result.append(new ArdhaUttanasana().build());
        result.append(new Unnamed_d3520675899a().build());
        result.append(new Unnamed_0cdcbfb6458d().build());
        result.append(danayamanaDhanurasana());
        result.append(ed7c24b3de79());
        result.append(e8ab2e5f8cba());
        result.append(a1e3f720bd3d());
        result.append(ekaPadaKaundiniAsanaSecond());
        result.append(a9c46dc25b04());
        result.append(new Vasisthasana().legsCrossed());
        result.append(new Vasisthasana().legExtended());
        result.append(new Unnamed_a9a6e36fef02().build());
        result.append(dhanurasana());
        result.append(new Unnamed_7e9edc7a803b().build());
        result.append(new Shalabhasana().build());
        result.append(new Makarasana().build());
        result.append(new Unnamed_44d66e4c4b2d().build());
        result.append(ashtangaNamaskara());
        result.append(adf790583a2b());
        result.append(ffbf000cd2c());
        result.append(bda5244496ee());
        result.append(new Makarasana().build());
        result.append(b01ed0397b45());
        result.append(new Outro().build());
        result.append("\n");

        return result.toString();
    }
}
