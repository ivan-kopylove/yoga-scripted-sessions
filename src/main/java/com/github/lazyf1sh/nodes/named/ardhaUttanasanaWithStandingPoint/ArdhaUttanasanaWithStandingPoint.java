package com.github.lazyf1sh.nodes.named.ardhaUttanasanaWithStandingPoint;

import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.nodes.Asana;

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