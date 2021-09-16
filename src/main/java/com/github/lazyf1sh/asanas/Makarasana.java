package com.github.lazyf1sh.asanas;

import com.github.lazyf1sh.sides.Side;
import com.github.lazyf1sh.util.YogaConfig;

import java.io.IOException;

import static com.github.lazyf1sh.sides.Sides.leftAblativeFeminine;
import static com.github.lazyf1sh.sides.Sides.rightAblativeFeminine;
import static com.github.lazyf1sh.util.Util.readFile;

public class Makarasana {
    private final YogaConfig yogaConfig;

    public Makarasana(final YogaConfig yogaConfig) {
        this.yogaConfig = yogaConfig;
    }

    public String build(final Side side) throws IOException {
        String makarasana = readFile("asanas/marakasana/makarasana-payload", yogaConfig.getLanguage());

        switch (side) {
            case LEFT_DEFAULT:
                makarasana = makarasana.replace("{{rightAblativeFeminine}}", leftAblativeFeminine());
                makarasana = makarasana.replace("{{leftAblativeFeminine}}", rightAblativeFeminine());
                break;
            case RIGHT:
                makarasana = makarasana.replace("{{rightAblativeFeminine}}", rightAblativeFeminine());
                makarasana = makarasana.replace("{{leftAblativeFeminine}}", leftAblativeFeminine());
                break;
        }

        if (yogaConfig.isSanscritMeaning()) {
            makarasana = makarasana.replace("{{makarasana-meaning}}", readFile("interpretations/makara", yogaConfig.getLanguage()));
        }

        return makarasana;
    }
}
