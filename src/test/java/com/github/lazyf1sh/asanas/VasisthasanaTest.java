package com.github.lazyf1sh.asanas;

import com.github.lazyf1sh.util.YogaConfig;
import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class VasisthasanaTest {

    @Test
    public void should_expected_result() throws IOException {
        // given

        // when
        final String result = new Vasisthasana(new YogaConfig(true, "ru")).legsCrossed();

        // then
        assertThat(result.length(), equalTo(461));
        assertThat(result.lines().count(), equalTo(16L));
        assertThat(result, containsString("Поза Мудреца Вас+иштхи или поза боковой планки"));
        containsNoCurlyBrackets(result);
    }

}