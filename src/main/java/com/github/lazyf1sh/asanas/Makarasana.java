package com.github.lazyf1sh.asanas;

import com.github.lazyf1sh.sides.AblativeCase;
import com.github.lazyf1sh.sides.Side;
import com.github.lazyf1sh.util.YogaConfig;

import java.io.IOException;

import static com.github.lazyf1sh.sides.Side.LEFT;
import static com.github.lazyf1sh.sides.Side.RIGHT;
import static com.github.lazyf1sh.util.Util.readFile;

public class Makarasana {
    private final YogaConfig yogaConfig;

    public Makarasana(final YogaConfig yogaConfig) {
        this.yogaConfig = yogaConfig;
    }

    public String build(final Side side) throws IOException {
        String makarasana = readFile("asanas/marakasana/makarasana-payload", yogaConfig.getLanguage());

        switch (side) {
            case LEFT:
                makarasana = makarasana.replace("{{right-ablative-case}}", new AblativeCase().get(LEFT));
                makarasana = makarasana.replace("{{left-ablative-case}}", new AblativeCase().get(RIGHT));
                break;
            case RIGHT:
                makarasana = makarasana.replace("{{right-ablative-case}}", new AblativeCase().get(RIGHT));
                makarasana = makarasana.replace("{{left-ablative-case}}", new AblativeCase().get(LEFT));
                break;
        }

        if (yogaConfig.isSanscritMeaning()) {
            makarasana = makarasana.replace("{{makarasana-meaning}}", readFile("interpretations/makara", yogaConfig.getLanguage()));
        }

        return makarasana;
    }
}
