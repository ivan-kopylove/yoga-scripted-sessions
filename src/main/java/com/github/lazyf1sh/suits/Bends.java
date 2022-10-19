package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.asanas.ardhaUttanasana.ArdhaUttanasana;
import com.github.lazyf1sh.asanas.ashtangaNamaskara.AshtangaNamaskara;
import com.github.lazyf1sh.asanas.dhanurasana.Dhanurasana;
import com.github.lazyf1sh.asanas.ekaPadaKaundiniAsana.EkaPadaKaundiniAsanaSecond;
import com.github.lazyf1sh.asanas.makarasana.Makarasana;
import com.github.lazyf1sh.asanas.shalabhasana.Shalabhasana;
import com.github.lazyf1sh.asanas.urdhvaHastasana.UrdhvaHastasana;
import com.github.lazyf1sh.asanas.vasisthasana.Vasisthasana;
import com.github.lazyf1sh.transitions.*;


import java.io.IOException;

import static com.github.lazyf1sh.util.Util.readFile;

public class Bends {

    

    public Bends() {
        
    }

    public String build() throws IOException {
        @SuppressWarnings("StringBufferReplaceableByString")
        final StringBuilder result = new StringBuilder();


        result.append(new Disclaimer().build());
        result.append(new CommonIntro().build());
        result.append(new UrdhvaHastasana().urdhvaHastasanaOnTiptoes());
        result.append(new Unnamed_f2238bca3e1b().build());
        result.append(new Unnamed_d6054818ad4b().build());
        result.append(new ArdhaUttanasana().build());
        result.append(new Unnamed_d3520675899a().build());
        result.append(new Unnamed_0cdcbfb6458d().build());
        result.append(new Dhanurasana().dandayamana());
        result.append(new Unnamed_ed7c24b3de79().build());
        result.append(new EkaPadaKaundiniAsanaSecond().build());
        result.append(new Unnamed_9c46dc25b049().build());
        result.append(new Vasisthasana().legsCrossed());
        result.append(new Vasisthasana().legExtended());
        result.append(new Unnamed_a9a6e36fef02().build());
        result.append(new Dhanurasana().build());
        result.append(new Unnamed_7e9edc7a803b().build());
        result.append(new Shalabhasana().build());
        result.append(new Makarasana().build());
        result.append(new Unnamed_44d66e4c4b2d().build());
        result.append(new AshtangaNamaskara().build());
        result.append(getBendsBody());
        result.append(new Outro().build());

        return result.toString();
    }

    private String getBendsBody() throws IOException {
        String bendsBody = readFile("bends-body.txt");

        bendsBody = bendsBody.replace("{{makarasana-left-hand-under-forehead}}", new Makarasana().build());

        return bendsBody;
    }
}
