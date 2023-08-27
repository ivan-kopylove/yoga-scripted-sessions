package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.asanas.named.SuryaNamaskar;
import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.asanas.named.SuryaNamaskar.suryaNamaskar;
import static com.github.lazyf1sh.util.CommonAssertion.allCommonChecks;
import static com.github.lazyf1sh.util.Util.convertToRu;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SuryaNamaskarTest
{

    @Test
    public void should_be_of_expected_length() throws IOException
    {
        // when
        String result = convertToRu(suryaNamaskar());

        // then
        assertThat(result.length(), equalTo(41215));
    }

    @Test
    public void should_pass_common_checks() throws IOException
    {
        // when
        String result = convertToRu(suryaNamaskar());

        // then
        allCommonChecks(result, SuryaNamaskar.class);
    }
}