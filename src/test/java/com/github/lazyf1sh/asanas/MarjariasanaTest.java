package com.github.lazyf1sh.asanas;

import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.asanas.named.marjariasana.Marjariasana.marjariasana;
import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static com.github.lazyf1sh.util.CommonAssertion.containsNoWords;
import static com.github.lazyf1sh.util.Util.convertToRu;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class MarjariasanaTest
{

    @Test
    public void should_draw_attention_when_length_has_changed() throws IOException
    {
        // when
        final String result = convertToRu(marjariasana());

        // then
        assertThat(result.length(), equalTo(254));
    }

    @Test
    public void should_pass_generic_check() throws IOException
    {
        // when
        final String result = convertToRu(marjariasana());

        // then
        containsNoCurlyBrackets(result);
        containsNoWords(result);
    }

    @Test
    public void should_contain_asana_name_ru() throws IOException
    {
        // when
        final String result = convertToRu(marjariasana());

        // then
        assertThat(result, containsString("Марджари+асана"));
        assertThat(result, containsString("Поза кошки"));
    }
}