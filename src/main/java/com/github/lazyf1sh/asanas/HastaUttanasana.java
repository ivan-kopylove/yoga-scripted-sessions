package com.github.lazyf1sh.asanas;

import com.github.lazyf1sh.microtype.FileName;
import com.github.lazyf1sh.util.YogaConfig;

import java.io.IOException;
import java.nio.file.Paths;

import static com.github.lazyf1sh.microtype.FileName.fileName;
import static com.github.lazyf1sh.util.Util.readAsana;

public class HastaUttanasana extends Asana {

    private final YogaConfig yogaConfig;
    private final FileName filename;

    protected HastaUttanasana(final YogaConfig yogaConfig, final FileName filename) {
        super(yogaConfig, filename);
        this.yogaConfig = yogaConfig;
        this.filename = filename;
    }

    public String build() throws IOException {
        return readAsana(Paths.get(filename.getValue()), yogaConfig.getLanguage(), yogaConfig.getSide());
    }

    public static String hastaUttanasana(final YogaConfig yogaConfig) throws IOException {
        return new HastaUttanasana(yogaConfig, fileName("hasta-uttanasana/hasta-uttanasana-payload")).build();
    }
}
