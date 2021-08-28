package com.github.lazyf1sh.asanas;

import com.github.lazyf1sh.util.YogaConfig;
import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.sides.Side.LEFT;
import static com.github.lazyf1sh.sides.Side.RIGHT;
import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class MakarasanaTest {

    @Test
    public void ru_length_check() throws IOException {
        // given
        final YogaConfig yoga = new YogaConfig(true, "ru");

        // when
        final String result = new Makarasana(yoga).build(RIGHT);


        assertThat(result.length(), equalTo(495));
        assertThat(result.lines().count(), equalTo(22L));
    }

    @Test
    public void ru_right() throws IOException {
        // then
        final String result = new Makarasana(new YogaConfig(true, "ru")).build(RIGHT);


        assertThat(result, containsString("На выдох тыльную часть правой ладони поместите под лоб."));
        assertThat(result, containsString("левой - под подбородок."));
        containsNoCurlyBrackets(result);
    }

    @Test
    public void ru_left() throws IOException {
        // then
        final String result = new Makarasana(new YogaConfig(true, "ru")).build(LEFT);

        assertThat(result, containsString("На выдох тыльную часть левой ладони поместите под лоб."));
        assertThat(result, containsString("правой - под подбородок."));
        containsNoCurlyBrackets(result);
    }

    @Test
    public void ru_meaning() throws IOException {
        // then
        final String result = new Makarasana(new YogaConfig(true, "ru")).build(LEFT);

        assertThat(result, containsString("Макара - в индийской традиции означает мифическое водное чудовище, имеющее сходство с крокодилом."));
        containsNoCurlyBrackets(result);
    }

    @Test
    public void en_meaning() throws IOException {
        // then
        final String result = new Makarasana(new YogaConfig(true, "en")).build(LEFT);

        assertThat(result, containsString("Makara is a legendary sea-creature in Hindu mythology."));
        containsNoCurlyBrackets(result);
    }
}