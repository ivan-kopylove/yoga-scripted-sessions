package com.github.lazyf1sh.asanas;

import com.github.lazyf1sh.util.YogaConfig;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class BalasanaTest {

    @Test
    public void should_be_of_expected_length_ru() throws IOException {
        // when
        final String result = new Balasana(YogaConfig.yogaConfigRuWithMeaning()).build();

        // then
        assertThat(result.length(), equalTo(536));
        assertThat(result.lines().count(), equalTo(19L));
    }

    @Test
    public void should_contain_asana_name() throws IOException {
        // when
        final String result = new Balasana(YogaConfig.yogaConfigRuWithMeaning()).build();

        // then
        assertThat(result, containsString("Бал+асана."));
        assertThat(result, containsString("Поза ребенка."));
    }


}