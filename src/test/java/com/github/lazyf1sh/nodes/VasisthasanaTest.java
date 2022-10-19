package com.github.lazyf1sh.nodes;

import com.github.lazyf1sh.nodes.vasisthasana.Vasisthasana;

import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class VasisthasanaTest {

    @Test
    public void legsCrossed() throws IOException {
        // when
        final String result = new Vasisthasana().legsCrossed();

        // then
        assertThat(result.length(), equalTo(429));
        assertThat(result, containsString("Поза Мудреца Вас+иштхи или поза боковой планки"));
        containsNoCurlyBrackets(result);
    }

    @Test
    public void should_expected_result() throws IOException {
        // when
        final String result = new Vasisthasana().legExtended();


        // then
        assertThat(result.length(), equalTo(212));
        assertThat(result, containsString("Вас+иштха +асана с вытянутой ногой."));
        containsNoCurlyBrackets(result);
    }


}