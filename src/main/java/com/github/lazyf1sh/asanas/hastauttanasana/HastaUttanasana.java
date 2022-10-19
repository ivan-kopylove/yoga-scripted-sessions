package com.github.lazyf1sh.asanas.hastauttanasana;

import com.github.lazyf1sh.asanas.Asana;
import com.github.lazyf1sh.microtype.FileName;


import java.io.IOException;
import java.nio.file.Paths;

import static com.github.lazyf1sh.microtype.FileName.fileName;
import static com.github.lazyf1sh.sides.Side.LEFT_DEFAULT;
import static com.github.lazyf1sh.util.Util.ReadAsanaParams.readAsanaParams;
import static com.github.lazyf1sh.util.Util.doRead2;

public class HastaUttanasana extends Asana {

    protected HastaUttanasana(final FileName filename) {
        super(filename);
    }

    public String build() throws IOException {
        return doRead2(readAsanaParams()
                .lang("ru")
                .side(LEFT_DEFAULT)
                .clazz(this.getClass())
                .path(Paths.get(filename.getValue())));
    }


    public static String hastaUttanasana() throws IOException {
        return new HastaUttanasana(fileName("hasta-uttanasana-payload")).build();
    }
}
