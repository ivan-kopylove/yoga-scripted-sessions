package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.util.YogaConfig;
import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static org.junit.Assert.assertEquals;

public class WarmupTest {

    @Test
    public void should_be_of_expected_size() throws IOException {
        // given
        final YogaConfig yogaConfig = new YogaConfig(true, "ru");

        // when
        final String result = new Warmup(yogaConfig).build();

        // then
        assertEquals(8732, result.length());
        containsNoCurlyBrackets(result);
    }

}