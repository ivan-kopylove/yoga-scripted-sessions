package com.github.lazyf1sh.asanas.named.rotateKneeOutwards;

import com.github.lazyf1sh.asanas.Asana;
import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;

public class RotateKneeOutwards extends Asana
{

    private RotateKneeOutwards()
    {
    }

    public static SourceFile rotateKneeOutwards() throws IOException
    {
        return new RotateKneeOutwards().build();
    }
}
