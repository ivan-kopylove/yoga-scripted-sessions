package com.github.lazyf1sh.asanas.tadasana;



import java.io.IOException;
import java.nio.file.Paths;

import static com.github.lazyf1sh.sides.Side.LEFT_DEFAULT;
import static com.github.lazyf1sh.util.Util.ReadAsanaParams.readAsanaParams;
import static com.github.lazyf1sh.util.Util.doRead2;

public class Tadasana {

    

    public Tadasana() {
        
    }

    public String quick() throws IOException {
        return doRead2(
                readAsanaParams()
                        .lang("ru")
                        .side(LEFT_DEFAULT)
                        .clazz(this.getClass())
                        .path(Paths.get("tadasana-quick-payload")));
    }

    public static String quickTadasana() throws IOException {
        return new Tadasana().quick();
    }

    public String palmsInNamaste() throws IOException {
        return doRead2(
                readAsanaParams()
                        .lang("ru")
                        .side(LEFT_DEFAULT)
                        .clazz(this.getClass())
                        .path(Paths.get("tadasana-palms-in-namaste")));
    }
}
