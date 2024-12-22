package com.github.lazyf1sh.suits;

import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.asanas.named.disclaimer.Disclaimer.disclaimer;
import static com.github.lazyf1sh.util.CommonAssertion.containsNoWords;
import static com.github.lazyf1sh.util.Util.convertToRu;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class DisclaimerTest {

    @Test
    public void should_contain_warnings() throws IOException {
        // given


        // when
        String result = convertToRu(disclaimer());

        // then
        assertThat(result, containsString("При боли прекратите упражнение"));
        containsNoWords(result);
    }
}