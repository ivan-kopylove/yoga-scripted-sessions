package com.github.lazyf1sh.nodes.vasisthasana;



import java.io.IOException;

import static com.github.lazyf1sh.util.Util.readFile;

public class Vasisthasana {

    

    public Vasisthasana() {
        
    }

    /**
     * google side-plank-pose-variation-legs-crossed https://imgur.com/a/UCoablH
     */
    public String legsCrossed() throws IOException {
        return readFile("asanas/vasisthasana/vasisthasana-legs-crossed-payload", "ru");
    }

    public String legExtended() throws IOException {
        return readFile("asanas/vasisthasana/vasisthasana-leg-extended-payload", "ru");
    }

}
