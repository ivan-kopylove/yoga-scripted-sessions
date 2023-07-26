package com.github.lazyf1sh.asanas;

import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.asanas.named.urdhvaHastasana.UrdhvaHastasanaOnHeels.urdhvaHastasanaOnHeels;
import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static com.github.lazyf1sh.util.Util.convertToRu;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class UrdhvaHastasanaOnHeelsTest
{

    @Test
    public void replaced_with_no_meaning() throws IOException
    {
        // when
        String result = convertToRu(urdhvaHastasanaOnHeels());

        // then
        assertThat(result.length(), equalTo(449));
        containsNoCurlyBrackets(result);
    }
}