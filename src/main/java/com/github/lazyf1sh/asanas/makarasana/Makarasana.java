package com.github.lazyf1sh.asanas.makarasana;

import com.github.lazyf1sh.util.YogaConfig;

import java.io.IOException;
import java.nio.file.Paths;

import static com.github.lazyf1sh.util.Util.ReadAsanaParams.readAsanaParams;
import static com.github.lazyf1sh.util.Util.doRead2;

public class Makarasana {
    private final YogaConfig yogaConfig;

    public Makarasana(final YogaConfig yogaConfig) {
        this.yogaConfig = yogaConfig;
    }

    public String build() throws IOException {
        return doRead2(
                readAsanaParams()
                        .lang(yogaConfig.getLanguage())
                        .side(yogaConfig.getSide())
                        .clazz(this.getClass())
                        .path(Paths.get("makarasana-payload")));
    }
}
