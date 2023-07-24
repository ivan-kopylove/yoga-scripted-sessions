package com.github.lazyf1sh.asanas;

import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.asanas.named.shalabhasana.Shalabhasana.shalabhasana;
import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static com.github.lazyf1sh.util.Util.convertToRu;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShalabhasanaTest
{

    @Test
    public void ru_length_check() throws IOException
    {
        // when
        final String result = convertToRu(shalabhasana());

        // then
        assertThat(result.length(), equalTo(237));
    }

    @Test
    public void should_contain_asana_name_ru() throws IOException
    {
        // given


        // when
        final String result = convertToRu(shalabhasana());

        // then
        assertThat(result, containsString("Шалабх+асана."));
        assertThat(result, containsString("Поза Саранчи."));
        containsNoCurlyBrackets(result);
    }
}