package com.github.lazyf1sh.nodes;

import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.nodes.makarasana.Makarasana.makarasana;
import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static com.github.lazyf1sh.util.Util.convertToRu;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class MakarasanaTest
{

    @Test
    public void ru_length_check() throws IOException
    {
        // when
        final String result = convertToRu(makarasana());

        assertThat(result.length(), equalTo(428));
    }

    @Test
    public void ru_left() throws IOException
    {
        // then
        final String result = convertToRu(makarasana());

        assertThat(result, containsString("Тыльную часть одной ладони поместите под лоб."));
        containsNoCurlyBrackets(result);
    }
}