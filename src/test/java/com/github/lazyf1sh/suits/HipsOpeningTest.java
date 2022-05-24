package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.util.YogaConfig;
import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.test.fixtures.YogaConfigTestFixtures.yogaConfigRuWithMeaning;
import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static com.github.lazyf1sh.util.CommonAssertion.containsNoWords;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class HipsOpeningTest {

    @Test
    public void should_be_of_expected_size() throws IOException {
        // given
        final HipsOpening hipsOpening = new HipsOpening(yogaConfigRuWithMeaning());

        // when
        final String result = hipsOpening.buildHipsOpeningSession();


        // then
        assertThat(result.length(), equalTo(46416));

    }

    @Test
    public void should_contain_specific_lines() throws IOException {
        // given
        final HipsOpening hipsOpening = new HipsOpening(yogaConfigRuWithMeaning());

        // when
        final String result = hipsOpening.buildHipsOpeningSession();

        // then
        assertThat(result, containsString("Урдхва хаст+асана на носках"));
        containsNoCurlyBrackets(result);
        containsNoWords(result);
    }

}