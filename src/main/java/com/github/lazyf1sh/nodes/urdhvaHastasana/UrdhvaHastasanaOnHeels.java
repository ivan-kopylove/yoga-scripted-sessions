package com.github.lazyf1sh.nodes.urdhvaHastasana;


import com.github.lazyf1sh.nodes.Asana;

import java.io.IOException;

public class UrdhvaHastasanaOnHeels extends Asana {



    private UrdhvaHastasanaOnHeels() {

    }


    public static String urdhvaHastasanaOnHeels() throws IOException {
        return new UrdhvaHastasanaOnHeels().build();
    }

}
