package com.github.lazyf1sh.asanas.makarasana;

import com.github.lazyf1sh.util.YogaConfig;

import java.io.IOException;
import java.nio.file.Paths;

import static com.github.lazyf1sh.util.Util.ReadAsanaParams.readAsanaParams;
import static com.github.lazyf1sh.util.Util.readAsana;
import static com.github.lazyf1sh.util.Util.readFile;

public class Makarasana {
    private final YogaConfig yogaConfig;

    public Makarasana(final YogaConfig yogaConfig) {
        this.yogaConfig = yogaConfig;
    }

    public String build() throws IOException {
        String makarasana = readAsana(
                readAsanaParams()
                        .lang(yogaConfig.getLanguage())
                        .side(yogaConfig.getSide())
                        .clazz(this.getClass())
                        .path(Paths.get("marakasana/makarasana-payload")));

        if (yogaConfig.isSanscritMeaning()) {
            makarasana = makarasana.replace("{{makarasana-meaning}}", readFile("interpretations/makara", yogaConfig.getLanguage()));
        }

        return makarasana;
    }
}
