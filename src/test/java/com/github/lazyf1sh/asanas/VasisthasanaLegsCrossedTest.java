package com.github.lazyf1sh.asanas;

import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.asanas.named.vasisthasana.VasisthasanaLegsCrossed.vasisthasanaLegsCrossed;
import static com.github.lazyf1sh.asanas.named.vasisthasana.VasisthasanaLegsExtended.vasisthasanaLegExtended;
import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static com.github.lazyf1sh.util.Util.convertToRu;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class VasisthasanaLegsCrossedTest
{

    @Test
    public void legsCrossed() throws IOException
    {
        // when
        final String result = convertToRu(vasisthasanaLegsCrossed());

        // then
        assertThat(result.length(), equalTo(433));
        assertThat(result, containsString("Поза Мудреца Вас+иштхи или поза боковой планки"));
        containsNoCurlyBrackets(result);
    }

    @Test
    public void should_expected_result() throws IOException
    {
        // when
        final String result = convertToRu(vasisthasanaLegExtended());


        // then
        assertThat(result.length(), equalTo(189));
        assertThat(result, containsString("Вас+иштха +асана с вытянутой ногой."));
        containsNoCurlyBrackets(result);
    }
}