package com.github.lazyf1sh.asanas.ardhaUttanasana;



import java.io.IOException;

import static com.github.lazyf1sh.util.Util.readFile;

public class ArdhaUttanasana {

    

    public ArdhaUttanasana() {
        
    }

    public String build() throws IOException {
        return readFile("asanas/ardha-uttanasana/ardha-uttanasana-payload", "ru");
    }
}
