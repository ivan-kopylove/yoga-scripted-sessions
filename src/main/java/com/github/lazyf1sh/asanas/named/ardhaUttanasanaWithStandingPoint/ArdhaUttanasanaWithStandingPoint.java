package com.github.lazyf1sh.asanas.named.ardhaUttanasanaWithStandingPoint;

import com.github.lazyf1sh.asanas.Asana;
import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;

public class ArdhaUttanasanaWithStandingPoint extends Asana
{

    private ArdhaUttanasanaWithStandingPoint()
    {

    }

    public static SourceFile ardhaUttanasanaWithStandingPoint() throws IOException
    {
        return new ArdhaUttanasanaWithStandingPoint().build();
    }
}