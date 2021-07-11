package com.github.lazyf1sh;

import java.io.IOException;
import java.util.Objects;

public class AsanasBuilder
{
    public static String urdhvaHastasanaOnTiptoes() throws IOException
    {
        return Util.readFile("urdhva-hastasana-on-tiptoes.txt");
    }

    public static String buildCommonIntro(String lang) throws IOException
    {
        Objects.requireNonNull(lang);
        return Util.readFile(String.format("common-intro-%s.txt", lang));
    }

    public static String buildCommonOutro() throws IOException
    {
        return Util.readFile("common-outro.txt");
    }
}
