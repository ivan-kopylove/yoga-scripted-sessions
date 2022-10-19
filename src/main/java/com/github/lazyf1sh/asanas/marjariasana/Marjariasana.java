package com.github.lazyf1sh.asanas.marjariasana;

import com.github.lazyf1sh.microtype.FileName;


import java.io.IOException;
import java.nio.file.Paths;

import static com.github.lazyf1sh.microtype.FileName.fileName;
import static com.github.lazyf1sh.sides.Side.LEFT_DEFAULT;
import static com.github.lazyf1sh.util.Util.ReadAsanaParams.readAsanaParams;
import static com.github.lazyf1sh.util.Util.doRead2;

public class Marjariasana {

    private final FileName fileName;

    private Marjariasana(final FileName fileName) {
        this.fileName = fileName;
    }


    public String build() throws IOException {
        return doRead2(
                readAsanaParams()
                        .lang("ru")
                        .side(LEFT_DEFAULT)
                        .clazz(this.getClass())
                        .path(Paths.get(fileName.getValue())));
    }

    public static Marjariasana marjariasana() {
        return new Marjariasana(fileName("marjariasana-payload"));
    }

    public String kneeToForeHead() throws IOException {
        return doRead2(
                readAsanaParams()
                        .lang("ru")
                        .side(LEFT_DEFAULT)
                        .clazz(this.getClass())
                        .path(Paths.get("marjariasana-knee-to-forehead-payload")));
    }
}
