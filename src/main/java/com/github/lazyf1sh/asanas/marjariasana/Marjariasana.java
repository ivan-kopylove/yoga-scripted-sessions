package com.github.lazyf1sh.asanas.marjariasana;

import com.github.lazyf1sh.microtype.FileName;
import com.github.lazyf1sh.util.YogaConfig;

import java.io.IOException;
import java.nio.file.Paths;

import static com.github.lazyf1sh.microtype.FileName.fileName;
import static com.github.lazyf1sh.util.Util.ReadAsanaParams.readAsanaParams;
import static com.github.lazyf1sh.util.Util.doRead2;

public class Marjariasana {

    private final YogaConfig yogaConfig;
    private final FileName fileName;

    public Marjariasana(final YogaConfig yogaConfig, final FileName fileName) {
        this.yogaConfig = yogaConfig;
        this.fileName = fileName;
    }


    public String build() throws IOException {
        return doRead2(
                readAsanaParams()
                        .lang(yogaConfig.getLanguage())
                        .side(yogaConfig.getSide())
                        .clazz(this.getClass())
                        .path(Paths.get(fileName.getValue())));
    }

    public static Marjariasana marjariasana(final YogaConfig yogaConfig) {
        return new Marjariasana(yogaConfig, fileName("marjariasana-payload"));
    }

    public String kneeToForeHead() throws IOException {
        return doRead2(
                readAsanaParams()
                        .lang(yogaConfig.getLanguage())
                        .side(yogaConfig.getSide())
                        .clazz(this.getClass())
                        .path(Paths.get("marjariasana-knee-to-forehead-payload")));
    }
}
