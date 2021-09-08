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
    public void all_assertions() throws IOException {
        // given
        final YogaConfig yogaConfig = new YogaConfig();
        yogaConfig.setSanscritMeaning(true);
        yogaConfig.setLanguage("ru");

        // when
        final String result = new SuryaNamaskar(yogaConfig).buildSuryaSession();

        // then
        assertThat(result.length(), equalTo(53462));
        assertThat(result.lines().count(), equalTo(2496L));
        assertThat(result, containsString("Урдхва хастасана на носках"));
        containsNoCurlyBrackets(result);
        containsNoWords(result);
    }
}