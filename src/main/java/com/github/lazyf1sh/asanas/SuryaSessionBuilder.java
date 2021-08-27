package com.github.lazyf1sh.asanas;

import com.github.lazyf1sh.AsanasBuilder;
import com.github.lazyf1sh.YogaConfig;
import com.github.lazyf1sh.asanas.transitions.Transition2acd3f67e8ed;

import java.io.IOException;

import static com.github.lazyf1sh.AsanasBuilder.buildCommonIntro;
import static com.github.lazyf1sh.AsanasBuilder.urdhvaHastasanaOnTiptoes;
import static com.github.lazyf1sh.Util.readFile;

public class SuryaSessionBuilder {
    private YogaConfig yogaConfig;

    public SuryaSessionBuilder(YogaConfig yogaConfig) {

        this.yogaConfig = yogaConfig;
    }

    @SuppressWarnings("StringBufferReplaceableByString")
    public String buildSuryaSession() throws IOException {
        StringBuilder result = new StringBuilder();
        result.append(buildCommonIntro("ru"));
        result.append(urdhvaHastasanaOnTiptoes());

        result.append(roundOne());
        result.append(readFile("surya-namaskar-round-02.txt"));
        result.append(readFile("surya-namaskar-round-03.txt"));
        //result.append(readFile("surya-namaskar-round-04.txt"));
        result.append(readFile("ardha-uttanasana-with-standing-point.txt"));
        result.append(readFile("kapalabhati-3-rounds.txt"));
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
        result.append(AsanasBuilder.buildCommonOutro());

        return result.toString();
    }

    @SuppressWarnings("StringBufferReplaceableByString")
    private String roundOne() throws IOException {
        StringBuilder result = new StringBuilder();
        result.append(new UrdhvaHastasana(yogaConfig).buildUrdhvaHastasana());
        result.append(new Transition2acd3f67e8ed().build());
        result.append(readFile("surya-namaskar-round-01.txt"));
        return result.toString();
    }
}
