package com.github.lazyf1sh.asanas.hastauttanasana;

import com.github.lazyf1sh.asanas.Asana;
import com.github.lazyf1sh.microtype.FileName;
import com.github.lazyf1sh.util.YogaConfig;

import java.io.IOException;
import java.nio.file.Paths;

import static com.github.lazyf1sh.microtype.FileName.fileName;
import static com.github.lazyf1sh.util.Util.ReadAsanaParams.readAsanaParams;
import static com.github.lazyf1sh.util.Util.readAsana;

public class HastaUttanasana extends Asana {

    protected HastaUttanasana(final YogaConfig yogaConfig, final FileName filename) {
        super(yogaConfig, filename);
    }

    public String build() throws IOException {
        return readAsana(readAsanaParams()
                .lang(yogaConfig.getLanguage())
                .side(yogaConfig.getSide())
                .clazz(this.getClass())
                .path(Paths.get(filename.getValue())));
    }


    public static String hastaUttanasana(final YogaConfig yogaConfig) throws IOException {
        return new HastaUttanasana(yogaConfig, fileName("hasta-uttanasana/hasta-uttanasana-payload")).build();
    }
}
