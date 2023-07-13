package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.asanas.named.outro.Outro;
import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static com.github.lazyf1sh.util.CommonAssertion.containsNoWords;
import static com.github.lazyf1sh.util.Util.convertToRu;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class OutroTest
{

    @Test
    public void should_be_of_expected_result() throws IOException
    {
        // when
        final String result = convertToRu(new Outro().build());

        // then
        assertThat(result.length(), equalTo(3643));
        containsNoCurlyBrackets(result);
        containsNoWords(result);
    }
}