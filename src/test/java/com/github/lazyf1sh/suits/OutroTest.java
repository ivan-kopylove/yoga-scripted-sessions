package com.github.lazyf1sh.suits;

import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;


public class OutroTest {

    @Test
    public void should_expected_result() throws IOException {
        // when
        final String result = new Outro().build();

        // then
        assertThat(result.length(), equalTo(4188));
        assertThat(result.lines().count(), equalTo(197L));
        containsNoCurlyBrackets(result);
    }

}