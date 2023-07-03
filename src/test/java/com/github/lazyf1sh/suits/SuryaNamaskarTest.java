package com.github.lazyf1sh.suits;

import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.util.CommonAssertion.allCommonChecks;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class SuryaNamaskarTest {

    @Test
    public void should_be_of_expected_length() throws IOException {
        // when
        final String result = new SuryaNamaskar().build();

        // then
        assertThat(result.length(), equalTo(38540));
    }

    @Test
    public void should_pass_common_checks() throws IOException {
        // when
        final String result = new SuryaNamaskar().build();

        // then
        allCommonChecks(result, SuryaNamaskar.class);
    }
}