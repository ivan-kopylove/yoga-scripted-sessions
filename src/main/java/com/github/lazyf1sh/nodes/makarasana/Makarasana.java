package com.github.lazyf1sh.nodes.makarasana;



import java.io.IOException;
import java.nio.file.Paths;

import static com.github.lazyf1sh.sides.Side.LEFT_DEFAULT;

import static com.github.lazyf1sh.util.ReadAsanaParams.readAsanaParams;
import static com.github.lazyf1sh.util.Util.doRead2;

public class Makarasana {
    


    public String build() throws IOException {
        return doRead2(
                readAsanaParams()
                        .lang("ru")
                        .side(LEFT_DEFAULT)
                        .clazz(this.getClass())
                        .path(Paths.get("makarasana-payload")));
    }
}