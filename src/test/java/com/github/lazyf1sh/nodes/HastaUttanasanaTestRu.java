package com.github.lazyf1sh.nodes;

import com.github.lazyf1sh.nodes.hastauttanasana.HastaUttanasana;

import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.nodes.hastauttanasana.HastaUttanasana.hastaUttanasana;

import static com.github.lazyf1sh.util.CommonAssertion.allCommonChecks;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class HastaUttanasanaTestRu implements GenericRuAsanaTest {

    @Test
    public void should_draw_attention_when_length_has_changed() throws IOException {
        // when
        final String result = hastaUttanasana();

        // then
        assertThat(result.length(), equalTo(779));
    }

    @Test
    public void should_contain_asana_name_ru() throws IOException {
        // when
        final String result = hastaUttanasana();

        // then
        assertThat(result, containsString("Хаста уттан+асана."));
    }

    @Override
    public void should_contain_asana_meaning_ru() throws IOException {
        fail();
    }

    @Test
    public void should_pass_generic_check_ru() throws IOException {
        // when

        final String result = hastaUttanasana();

        // then
        allCommonChecks(result, HastaUttanasana.class);
    }

}