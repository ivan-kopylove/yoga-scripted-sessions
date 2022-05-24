package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.util.YogaConfig;
import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.test.fixtures.YogaConfigTestFixtures.yogaConfigRuWithMeaning;
import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static com.github.lazyf1sh.util.CommonAssertion.containsNoWords;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CommonIntroTest {

    @Test
    public void should_be_of_expected_size() throws IOException {
        // when
        final String result = new CommonIntro(yogaConfigRuWithMeaning()).build();

        // then
        assertThat(result.length(), equalTo(9334));
        containsNoCurlyBrackets(result);
        containsNoWords(result);
    }

}