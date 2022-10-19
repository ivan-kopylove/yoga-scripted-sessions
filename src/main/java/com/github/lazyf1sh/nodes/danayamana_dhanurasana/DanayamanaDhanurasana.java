package com.github.lazyf1sh.nodes.danayamana_dhanurasana;

import com.github.lazyf1sh.microtype.FileName;
import com.github.lazyf1sh.nodes.Asana;
import com.github.lazyf1sh.nodes.Asana2;

import java.io.IOException;

import static com.github.lazyf1sh.util.Util.readFile;

public class DanayamanaDhanurasana extends Asana2 {

    private DanayamanaDhanurasana() {}

    public static String danayamanaDhanurasana() throws IOException {
        return new DanayamanaDhanurasana().build();
    }
}
