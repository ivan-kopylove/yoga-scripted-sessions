package com.github.lazyf1sh.asanas;

import com.github.lazyf1sh.asanas.balasana.Balasana;
import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.test.fixtures.YogaConfigTestFixtures.yogaConfigRuWithMeaning;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class BalasanaTest {

    @Test
    public void should_draw_attention_when_length_has_changed() throws IOException {
        // when
        final String result = new Balasana(yogaConfigRuWithMeaning()).build();

        // then
        assertThat(result.length(), equalTo(536));
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