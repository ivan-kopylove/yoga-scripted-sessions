package com.github.lazyf1sh;

import java.io.IOException;

public class AsanasBuilder
{
    public static String urdhvaHastasanaOnTiptoes() throws IOException
    {
        return Util.readFile("urdhva-hastasana-on-tiptoes.txt");
    }

    public static String buildCommonIntro() throws IOException
    {
        return Util.readFile("common-intro.txt");
    }

    public static String buildCommonOutro() throws IOException
    {
        return Util.readFile("common-outro.txt");
    }
}
