package com.github.lazyf1sh.asanas.urdhvaHastasana;



import java.io.IOException;
import java.nio.file.Paths;

import static com.github.lazyf1sh.util.Util.readFile;

public class UrdhvaHastasana {
    private static final String ON_HEELS_PATH = "asanas/urdhva-hastasana/urdhva-hastasana-on-heels.txt";
    private static final String ON_TIPTOES_PATH = "asanas/urdhva-hastasana/urdhva-hastasana-on-tiptoes";



    public String build() throws IOException {
        return readFile(ON_HEELS_PATH);
    }

    public String urdhvaHastasanaOnTiptoes() throws IOException {
        return readFile(Paths.get(ON_TIPTOES_PATH), "ru");
    }

}
