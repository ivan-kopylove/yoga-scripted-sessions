package com.github.lazyf1sh.nodes.balasana;

import com.github.lazyf1sh.suits.YogaSessionTextBuilder;

import java.nio.file.Paths;

public class Balasana extends YogaSessionTextBuilder
{
    public Balasana()
    {
        super(Paths.get("asanas/balasana/balasana-payload"));
    }
}
