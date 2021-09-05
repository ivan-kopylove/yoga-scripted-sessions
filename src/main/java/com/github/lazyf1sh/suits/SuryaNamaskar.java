package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.asanas.AgnisarKriya;
import com.github.lazyf1sh.asanas.UrdhvaHastasana;
import com.github.lazyf1sh.transitions.Unnamed_2acd3f67e8ed;
import com.github.lazyf1sh.util.YogaConfig;

import java.io.IOException;

import static com.github.lazyf1sh.util.Util.readFile;

public class SuryaNamaskar {
    private final YogaConfig yogaConfig;

    public SuryaNamaskar(final YogaConfig yogaConfig) {

        this.yogaConfig = yogaConfig;
    }

    @SuppressWarnings("StringBufferReplaceableByString")
    public String buildSuryaSession() throws IOException {
        final StringBuilder result = new StringBuilder();
        result.append(new CommonIntro(yogaConfig).build());

        result.append(roundOne());
        result.append(readFile("surya-namaskar-round-02.txt"));
        result.append(readFile("surya-namaskar-round-03.txt"));
        //result.append(readFile("surya-namaskar-round-04.txt"));
        result.append(readFile("ardha-uttanasana-with-standing-point.txt"));
        result.append(readFile("kapalabhati.txt"));
        result.append(new AgnisarKriya(yogaConfig).build());
        result.append(readFile("bitilasana.txt"));
        result.append(readFile("marjariasana-with-knee-to-elbow.txt"));
        result.append(readFile("dandayamana-Bharmanasana-balancing-table.txt"));
        result.append(readFile("eka-hasta-vjagrasana-cross-hook.txt"));
        result.append(readFile("eka-pada-adho-mukha-svanasana-with-elbow-down.txt"));
        result.append(readFile("transition-ef2eb0af2276.txt"));
        result.append(readFile("dolphin.txt"));
        result.append(readFile("transition-b21ef52bd090.txt"));
        result.append(readFile("spring-of-leg-moved-to-a-side.txt"));
        result.append(readFile("transition-266ae7aacbff.txt"));
        result.append(readFile("rotate-a-knee-outwards.txt"));
        result.append(readFile("unknown-d856222abcd5.txt"));
        result.append(readFile("big-toe-to-ear.txt"));
        result.append(readFile("eka-hasta-vjagrasana-one-side-hook.txt"));
        result.append(readFile("surya-namaskar-sides.txt"));
        result.append(new Outro().build());

        return result.toString();
    }

    @SuppressWarnings("StringBufferReplaceableByString")
    private String roundOne() throws IOException {
        final StringBuilder result = new StringBuilder();

        final UrdhvaHastasana urdhvaHastasana = new UrdhvaHastasana(yogaConfig);


        result.append(urdhvaHastasana.urdhvaHastasanaOnTiptoes());
        result.append(urdhvaHastasana.build());
        result.append(new Unnamed_2acd3f67e8ed().build());
        result.append(readFile("surya-namaskar-round-01.txt"));
        return result.toString();
    }
}
