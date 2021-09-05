package com.github.lazyf1sh.asanas;

import com.github.lazyf1sh.util.YogaConfig;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class AgnisarKriyaTest {

    @Test
    public void should_be_of_expected_length_ru() throws IOException {
        // given
        final YogaConfig ru = new YogaConfig(true, "ru");
        // when

        final String result = new AgnisarKriya(ru).build();

        // then
        assertThat(result.length(), equalTo(863));
        assertThat(result.lines().count(), equalTo(38L));
    }

    @Test
    public void should_contain_asana_name_ru() throws IOException {
        // given
        final YogaConfig ru = new YogaConfig(true, "ru");
        // when

        final String result = new AgnisarKriya(ru).build();

        // then
        assertThat(result, containsString("Агнисара Дхаути Крийя."));
        assertThat(result, containsString("Очищение внутренним огнём."));
    }


}