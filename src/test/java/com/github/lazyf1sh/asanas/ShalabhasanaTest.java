package com.github.lazyf1sh.asanas;

import com.github.lazyf1sh.asanas.shalabhasana.Shalabhasana;
import com.github.lazyf1sh.util.YogaConfig;
import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.test.fixtures.YogaConfigTestFixtures.yogaConfigRuWithMeaning;
import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ShalabhasanaTest {

    @Test
    public void ru_length_check() throws IOException {
        // when
        final String result = new Shalabhasana(yogaConfigRuWithMeaning()).build();

        // then
        assertThat(result.length(), equalTo(227));
    }

    @Test
    public void should_contain_asana_name_ru() throws IOException {
        // given
        final YogaConfig yogaConfig = new YogaConfig(true, "ru");

        // when
        final String result = new Shalabhasana(yogaConfig).build();

        // then
        assertThat(result, containsString("Шалабх+асана."));
        assertThat(result, containsString("Поза Саранчи."));
        containsNoCurlyBrackets(result);
    }
}