package com.github.lazyf1sh.asanas;

import com.github.lazyf1sh.asanas.makarasana.Makarasana;
import com.github.lazyf1sh.util.YogaConfig;
import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.sides.Side.LEFT_DEFAULT;
import static com.github.lazyf1sh.sides.Side.RIGHT;
import static com.github.lazyf1sh.util.CommonAssertion.allCommonChecks;
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
        final String result = new Makarasana(yoga).build();


        assertThat(result.length(), equalTo(489));
        assertThat(result.lines().count(), equalTo(22L));
    }

    @Test
    public void ru_right() throws IOException {
        // then
        final String result = new Makarasana(new YogaConfig(true, "ru", RIGHT)).build();


        assertThat(result, containsString("На выдох тыльную часть правой ладони поместите под лоб."));
        assertThat(result, containsString("левой - под подбородок."));
        containsNoCurlyBrackets(result);
    }

    @Test
    public void ru_left() throws IOException {
        // then
        final String result = new Makarasana(new YogaConfig(true, "ru", LEFT_DEFAULT)).build();

        assertThat(result, containsString("На выдох тыльную часть левой ладони поместите под лоб."));
        assertThat(result, containsString("правой - под подбородок."));
        containsNoCurlyBrackets(result);
    }

    @Test
    public void ru_meaning() throws IOException {
        // then
        final String result = new Makarasana(new YogaConfig(true, "ru", LEFT_DEFAULT)).build();

        assertThat(result, containsString("Макара - в индийской традиции - мифическое водное чудовище, имеющее сходство с крокодилом."));
        containsNoCurlyBrackets(result);
    }

    @Test
    public void en_meaning() throws IOException {
        // then
        final YogaConfig yogaConfig = new YogaConfig(true, "en", LEFT_DEFAULT);
        final String result = new Makarasana(yogaConfig).build();

        // then
        assertThat(result, containsString("Makara is a legendary sea-creature in Hindu mythology."));


        allCommonChecks(result, Makarasana.class, yogaConfig);
    }
}