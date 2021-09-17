package com.github.lazyf1sh.asanas;

import com.github.lazyf1sh.util.YogaConfig;

import java.io.IOException;
import java.nio.file.Paths;

import static com.github.lazyf1sh.util.Util.readFile;

public class Tadasana {

    private final YogaConfig yogaConfig;

    public Tadasana(final YogaConfig yogaConfig) {
        this.yogaConfig = yogaConfig;
    }

    public String quick() throws IOException {
        return readFile(Paths.get("asanas/tadasana/tadasana-quick-payload"), yogaConfig.getLanguage());
    }

    public static String quickTadasana(final YogaConfig yogaConfig) throws IOException {
        return new Tadasana(yogaConfig).quick();
    }

    public String palmsInNamaste() throws IOException {
        final String language = yogaConfig.getLanguage();

        String tadasana = readFile(Paths.get("asanas/tadasana/tadasana-palms-in-namaste"), language);

        if (yogaConfig.isSanscritMeaning()) {
            final String tadasanaMeaning = readFile(Paths.get("interpretations/tada"), language);
            tadasana = tadasana.replace("{{tadasana-meaning}}", tadasanaMeaning);
        } else {
            tadasana = tadasana.replace("{{tadasana-meaning}}", "");
        }

        return tadasana;
    }
}
