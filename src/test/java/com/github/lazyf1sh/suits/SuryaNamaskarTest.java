package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.util.YogaConfig;
import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static com.github.lazyf1sh.util.CommonAssertion.containsNoWords;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class SuryaNamaskarTest {

    @Test
    public void should_be_of_expected_length() throws IOException {
        // given
        final YogaConfig yogaConfig = new YogaConfig();
        yogaConfig.setSanscritMeaning(true);
        yogaConfig.setLanguage("ru");

        // when
        final String result = new SuryaNamaskar(yogaConfig).buildSuryaSession();

        // then
        assertThat(result.length(), equalTo(52652));

    }

    @Test
    public void should_contain_specific_lines() throws IOException {
        // given
        final YogaConfig yogaConfig = new YogaConfig();
        yogaConfig.setSanscritMeaning(true);
        yogaConfig.setLanguage("ru");

        // when
        final String result = new SuryaNamaskar(yogaConfig).buildSuryaSession();

        // then
        assertThat(result, containsString("Урдхва хаст+асана на носках"));
        containsNoCurlyBrackets(result);
        containsNoWords(result);
    }


}