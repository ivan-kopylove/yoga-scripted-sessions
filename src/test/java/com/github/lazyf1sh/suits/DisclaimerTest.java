package com.github.lazyf1sh.suits;


import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.util.CommonAssertion.containsNoWords;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class DisclaimerTest {

    @Test
    public void should_expected_result() throws IOException {
        // given



        // when
        final String result = new Disclaimer().build();

        // then
        assertThat(result.length(), equalTo(257));
    }

    @Test
    public void should_contain_warnings() throws IOException {
        // given



        // when
        final String result = new Disclaimer().build();

        // then
        assertThat(result, containsString("При боли прекратите упражнение"));
        containsNoWords(result);
    }


}