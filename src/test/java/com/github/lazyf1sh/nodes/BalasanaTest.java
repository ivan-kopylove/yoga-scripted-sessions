package com.github.lazyf1sh.nodes;

import com.github.lazyf1sh.nodes.balasana.Balasana;
import org.junit.Test;

import java.io.IOException;


import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class BalasanaTest {

    @Test
    public void should_draw_attention_when_length_has_changed() throws IOException {
        // when
        final String result = new Balasana().build();

        // then
        assertThat(result.length(), equalTo(585));
    }

    @Test
    public void should_contain_asana_name() throws IOException {
        // when
        final String result = new Balasana().build();

        // then
        assertThat(result, containsString("Бал+асана."));
        assertThat(result, containsString("Поза ребенка."));
    }


}