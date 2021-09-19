package com.github.lazyf1sh.asanas;

import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.asanas.Marjariasana.marjariasana;
import static com.github.lazyf1sh.test.fixtures.YogaConfigTestFixtures.yogaConfigRuWithMeaning;
import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static com.github.lazyf1sh.util.CommonAssertion.containsNoWords;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class MarjariasanaTest {

    @Test
    public void should_be_of_expected_length_ru() throws IOException {
        // when
        final String result = marjariasana(yogaConfigRuWithMeaning()).build();

        // then
        assertThat(result.length(), equalTo(258));
        assertThat(result.lines().count(), equalTo(14L));
    }

    @Test
    public void should_pass_generic_check() throws IOException {
        // when
        final String result = marjariasana(yogaConfigRuWithMeaning()).build();

        // then
        containsNoCurlyBrackets(result);
        containsNoWords(result);
    }


    @Test
    public void should_contain_asana_name_ru() throws IOException {
        // when
        final String result = marjariasana(yogaConfigRuWithMeaning()).build();

        // then
        assertThat(result, containsString("Марджари+асана"));
        assertThat(result, containsString("Поза кошки"));
    }
}