package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.asanas.*;
import com.github.lazyf1sh.transitions.*;
import com.github.lazyf1sh.util.YogaConfig;

import java.io.IOException;

import static com.github.lazyf1sh.sides.Side.LEFT;
import static com.github.lazyf1sh.sides.Side.RIGHT;
import static com.github.lazyf1sh.util.Util.readFile;

public class Bends {

    private final YogaConfig yogaConfig;

    public Bends(final YogaConfig yogaConfig) {
        this.yogaConfig = yogaConfig;
    }

    public String build() throws IOException {
        final StringBuilder result = new StringBuilder();

        result.append(new Warmup(yogaConfig).build());

        result.append(new UrdhvaHastasana(yogaConfig).urdhvaHastasanaOnTiptoes());
        result.append(new Unnamed_f2238bca3e1b(yogaConfig).build());
        result.append(new Unnamed_d6054818ad4b(yogaConfig).build());
        result.append(new ArdhaUttanasana(yogaConfig).build());
        result.append(new Unnamed_d3520675899a(yogaConfig).build());
        result.append(new Unnamed_0cdcbfb6458d(yogaConfig).build());
        result.append(new Dhanurasana(yogaConfig).dandayamana());
        result.append(new Unnamed_ed7c24b3de79(yogaConfig).build());
        result.append(new EkaPadaKaundiniAsanaSecond(yogaConfig).build());
        result.append(new Unnamed_9c46dc25b049(yogaConfig).build());
        result.append(new Vasisthasana(yogaConfig).legsCrossed());
        result.append(new Vasisthasana(yogaConfig).legExtended());
        result.append(new Unnamed_a9a6e36fef02(yogaConfig).build());
        result.append(new Dhanurasana(yogaConfig).build());
        result.append(new Unnamed_7e9edc7a803b(yogaConfig).build());
        result.append(new Shalabhasana(yogaConfig).build());
        result.append(new Makarasana(yogaConfig).build(RIGHT));
        result.append(new Unnamed_44d66e4c4b2d(yogaConfig).build());

        result.append(getBendsBody());
        result.append(new Outro().build());

        return result.toString();
    }

    private String getBendsBody() throws IOException {
        String bendsBody = readFile("bends-body.txt");

        bendsBody = bendsBody.replace("{{makarasana-left-hand-under-forehead}}", new Makarasana(yogaConfig).build(LEFT));

        return bendsBody;
    }
}
