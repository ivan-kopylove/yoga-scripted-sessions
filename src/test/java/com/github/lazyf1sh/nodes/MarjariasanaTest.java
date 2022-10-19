package com.github.lazyf1sh.nodes;

import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.nodes.marjariasana.Marjariasana.marjariasana;

import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static com.github.lazyf1sh.util.CommonAssertion.containsNoWords;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class MarjariasanaTest {

    @Test
    public void should_draw_attention_when_length_has_changed() throws IOException {
        // when
        final String result = marjariasana().build();

        // then
        assertThat(result.length(), equalTo(252));
    }

    @Test
    public void should_pass_generic_check() throws IOException {
        // when
        final String result = marjariasana().build();

        // then
        containsNoCurlyBrackets(result);
        containsNoWords(result);
    }


    @Test
    public void should_contain_asana_name_ru() throws IOException {
        // when
        final String result = marjariasana().build();

        // then
        assertThat(result, containsString("Марджари+асана"));
        assertThat(result, containsString("Поза кошки"));
    }
}