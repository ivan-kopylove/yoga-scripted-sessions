package com.github.lazyf1sh.nodes;

import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.nodes.urdhvaHastasana.UrdhvaHastasanaOnHeels.urdhvaHastasanaOnHeels;
import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static com.github.lazyf1sh.util.Util.convertToRu;
import static org.junit.Assert.assertEquals;

public class UrdhvaHastasanaOnHeelsTest
{

    @Test
    public void replaced_with_no_meaning() throws IOException
    {
        // given


        // when
        final String result = convertToRu(urdhvaHastasanaOnHeels());

        // then
        assertEquals(438, result.length());
        containsNoCurlyBrackets(result);
    }
}