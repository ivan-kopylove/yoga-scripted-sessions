package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.nodes.known.commonIntro.CommonWarmup;
import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static com.github.lazyf1sh.util.CommonAssertion.containsNoWords;
import static com.github.lazyf1sh.util.Util.convertToRu;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CommonWarmupTest
{

    @Test
    public void should_be_of_expected_size() throws IOException
    {
        // when
        final String result = convertToRu(new CommonWarmup().build());

        // then
        assertThat(result.length(), equalTo(9824));
        containsNoCurlyBrackets(result);
        containsNoWords(result);
    }
}