package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.util.YogaConfig;
import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static com.github.lazyf1sh.util.CommonAssertion.containsNoWords;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CommonIntroTest {

    @Test
    public void should_be_of_expected_size() throws IOException {
        // given
        final YogaConfig yogaConfig = new YogaConfig(true, "ru");

        // when
        final String result = new CommonIntro(yogaConfig).build();

        // then
        assertThat(result.length(), equalTo(9469));
        assertThat(result.lines().count(), equalTo(424L));
        containsNoCurlyBrackets(result);
        containsNoWords(result);
    }

}