package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.nodes.ardhaUttanasana.ArdhaUttanasana;
import com.github.lazyf1sh.nodes.makarasana.Makarasana;
import com.github.lazyf1sh.nodes.shalabhasana.Shalabhasana;
import com.github.lazyf1sh.nodes.urdhvaHastasana.UrdhvaHastasana;
import com.github.lazyf1sh.nodes.vasisthasana.Vasisthasana;
import com.github.lazyf1sh.transitions.*;


import java.io.IOException;

import static com.github.lazyf1sh.nodes.ashtangaNamaskara.AshtangaNamaskara.ashtangaNamaskara;
import static com.github.lazyf1sh.nodes.danayamana_dhanurasana.DanayamanaDhanurasana.danayamanaDhanurasana;
import static com.github.lazyf1sh.nodes.dhanurasana.Dhanurasana.dhanurasana;
import static com.github.lazyf1sh.nodes.ekaPadaKaundiniAsanaSecond.EkaPadaKaundiniAsanaSecond.ekaPadaKaundiniAsanaSecond;
import static com.github.lazyf1sh.util.Util.readFile;

public class Bends {
    private Bends() {

    }

    public static String bends() throws IOException {
        return new Bends().build();
    }

    public String build() throws IOException {
        @SuppressWarnings("StringBufferReplaceableByString")
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
        result.append(new Unnamed_ed7c24b3de79().build());
        result.append(ekaPadaKaundiniAsanaSecond());
        result.append(new Unnamed_9c46dc25b049().build());
        result.append(new Vasisthasana().legsCrossed());
        result.append(new Vasisthasana().legExtended());
        result.append(new Unnamed_a9a6e36fef02().build());
        result.append(dhanurasana());
        result.append(new Unnamed_7e9edc7a803b().build());
        result.append(new Shalabhasana().build());
        result.append(new Makarasana().build());
        result.append(new Unnamed_44d66e4c4b2d().build());
        result.append(ashtangaNamaskara());
        result.append(getBendsBody());
        result.append(new Outro().build());
        result.append("\n");

        return result.toString();
    }

    private String getBendsBody() throws IOException {
        String bendsBody = readFile("bends-body.txt");

        bendsBody = bendsBody.replace("{{makarasana-left-hand-under-forehead}}", new Makarasana().build());

        return bendsBody;
    }
}
