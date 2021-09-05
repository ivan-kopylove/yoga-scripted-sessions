package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.util.YogaConfig;
import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.util.CommonAssertion.containsNoWords;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class AlpenvillaYogaIntroTest {

    @Test
    public void should_be_of_expected_size() throws IOException {
        // when
        final String result = new AlpenvillaYogaIntro(new YogaConfig(false, "ru")).build();

        // then
        assertThat(result.length(), equalTo(152));
        assertThat(result.lines().count(), equalTo(3L));
        containsNoWords(result);
    }
}