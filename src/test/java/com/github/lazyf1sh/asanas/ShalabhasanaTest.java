package com.github.lazyf1sh.asanas;

import com.github.lazyf1sh.util.YogaConfig;
import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ShalabhasanaTest {

    @Test
    public void ru_length_check() throws IOException {
        // given
        final YogaConfig yogaConfig = new YogaConfig(true, "ru");

        // when
        final String result = new Shalabhasana(yogaConfig).build();

        assertThat(result.length(), equalTo(206));
        assertThat(result.lines().count(), equalTo(8L));
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