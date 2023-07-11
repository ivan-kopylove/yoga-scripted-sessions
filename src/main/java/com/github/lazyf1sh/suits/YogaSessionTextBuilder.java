package com.github.lazyf1sh.suits;


import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;
import java.nio.file.Path;

import static com.github.lazyf1sh.util.Util.readFile;

public abstract class YogaSessionTextBuilder
{
    protected final Path path;

    public YogaSessionTextBuilder(final Path path)
    {
        this.path = path;
    }

    public SourceFile build() throws IOException
    {
        return readFile(path, "ru");
    }
}
