package com.github.lazyf1sh.suits;

import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.suits.SuryaNamaskar.suryaNamaskar;
import static com.github.lazyf1sh.util.CommonAssertion.allCommonChecks;
import static com.github.lazyf1sh.util.Util.convertToRu;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class SuryaNamaskarTest
{

    @Test
    public void should_be_of_expected_length() throws IOException
    {
        // when
        final String result = convertToRu(suryaNamaskar());

        // then
        assertThat(result.length(), equalTo(40275));
    }

    @Test
    public void should_pass_common_checks() throws IOException
    {
        // when
        final String result = convertToRu(suryaNamaskar());

        // then
        allCommonChecks(result, SuryaNamaskar.class);
    }
}