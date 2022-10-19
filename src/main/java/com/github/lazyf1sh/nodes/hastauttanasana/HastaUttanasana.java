package com.github.lazyf1sh.nodes.hastauttanasana;

import com.github.lazyf1sh.nodes.Asana;
import com.github.lazyf1sh.microtype.FileName;
import com.github.lazyf1sh.nodes.Asana2;


import java.io.IOException;
import java.nio.file.Paths;

import static com.github.lazyf1sh.microtype.FileName.fileName;
import static com.github.lazyf1sh.sides.Side.LEFT_DEFAULT;

import static com.github.lazyf1sh.util.ReadAsanaParams.readAsanaParams;
import static com.github.lazyf1sh.util.Util.doRead2;

public class HastaUttanasana extends Asana2 {

    private HastaUttanasana() {

    }

    public static String hastaUttanasana() throws IOException {
        return new HastaUttanasana().build();
    }
}
