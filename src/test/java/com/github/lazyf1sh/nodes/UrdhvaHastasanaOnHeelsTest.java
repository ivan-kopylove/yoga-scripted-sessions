package com.github.lazyf1sh.nodes;

import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.nodes.named.urdhvaHastasana.UrdhvaHastasanaOnHeels.urdhvaHastasanaOnHeels;
import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static com.github.lazyf1sh.util.Util.convertToRu;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class UrdhvaHastasanaOnHeelsTest
{

    @Test
    public void replaced_with_no_meaning() throws IOException
    {
        // when
        final String result = convertToRu(urdhvaHastasanaOnHeels());

        // then
        assertThat(result.length(), equalTo(449));
        containsNoCurlyBrackets(result);
    }
}