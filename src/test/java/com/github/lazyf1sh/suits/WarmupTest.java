package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.util.YogaConfig;
import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class WarmupTest {

    @Test
    public void should_be_of_expected_size() throws IOException {
        // given
        final YogaConfig yogaConfig = new YogaConfig(true, "ru");

        // when
        final String result = new Warmup(yogaConfig).build();

        // then
        assertThat(result.length(), equalTo(8741));
        assertThat(result.lines().count(), equalTo(374L));
        containsNoCurlyBrackets(result);
    }

}