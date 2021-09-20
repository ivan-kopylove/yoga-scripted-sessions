package com.github.lazyf1sh.asanas.tadasana;

import com.github.lazyf1sh.util.YogaConfig;

import java.io.IOException;
import java.nio.file.Paths;

import static com.github.lazyf1sh.util.Util.ReadAsanaParams.readAsanaParams;
import static com.github.lazyf1sh.util.Util.doRead2;

public class Tadasana {

    private final YogaConfig yogaConfig;

    public Tadasana(final YogaConfig yogaConfig) {
        this.yogaConfig = yogaConfig;
    }

    public String quick() throws IOException {
        return doRead2(
                readAsanaParams()
                        .lang(yogaConfig.getLanguage())
                        .side(yogaConfig.getSide())
                        .clazz(this.getClass())
                        .path(Paths.get("tadasana-quick-payload")));
    }

    public static String quickTadasana(final YogaConfig yogaConfig) throws IOException {
        return new Tadasana(yogaConfig).quick();
    }

    public String palmsInNamaste() throws IOException {
        return doRead2(
                readAsanaParams()
                        .lang(yogaConfig.getLanguage())
                        .side(yogaConfig.getSide())
                        .clazz(this.getClass())
                        .path(Paths.get("tadasana-palms-in-namaste")));
    }
}
