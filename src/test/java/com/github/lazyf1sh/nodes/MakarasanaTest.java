package com.github.lazyf1sh.nodes;

import com.github.lazyf1sh.nodes.makarasana.Makarasana;

import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class MakarasanaTest {

    @Test
    public void ru_length_check() throws IOException {
        // when
        final String result = new Makarasana().build();


        assertThat(result.length(), equalTo(486));
    }

    @Test
    public void ru_left() throws IOException {
        // then
        final String result = new Makarasana().build();

        assertThat(result, containsString("На выдох тыльную часть левой ладони поместите под лоб."));
        assertThat(result, containsString("правой - под подбородок."));
        containsNoCurlyBrackets(result);
    }

    @Test
    public void ru_meaning() throws IOException {
        // then
        final String result = new Makarasana().build();

        assertThat(result, containsString("Макара - в индийской традиции - мифическое водное чудовище, имеющее сходство с крокодилом."));
        containsNoCurlyBrackets(result);
    }
}