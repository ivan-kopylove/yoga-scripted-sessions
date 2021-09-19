package com.github.lazyf1sh.asanas;

import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.test.fixtures.YogaConfigTestFixtures.yogaConfigRuWithMeaning;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class BalasanaTest {

    @Test
    public void should_be_of_expected_length_ru() throws IOException {
        // when
        final String result = new Balasana(yogaConfigRuWithMeaning()).build();

        // then
        assertThat(result.length(), equalTo(536));
        assertThat(result.lines().count(), equalTo(19L));
    }

    @Test
    public void should_contain_asana_name() throws IOException {
        // when
        final String result = new Balasana(yogaConfigRuWithMeaning()).build();

        // then
        assertThat(result, containsString("Бал+асана."));
        assertThat(result, containsString("Поза ребенка."));
    }


}