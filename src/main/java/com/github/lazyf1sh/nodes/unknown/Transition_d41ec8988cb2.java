package com.github.lazyf1sh.nodes.unknown;

import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.suits.YogaSessionTextBuilder;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Transition_d41ec8988cb2 extends YogaSessionTextBuilder
{
    public Transition_d41ec8988cb2(final Path path)
    {
        super(path);
    }

    public static SourceFile transition_d41ec8988cb2() throws IOException
    {
        return new Transition_d41ec8988cb2(Paths.get("transitions/d41ec8988cb2")).build();
    }
}