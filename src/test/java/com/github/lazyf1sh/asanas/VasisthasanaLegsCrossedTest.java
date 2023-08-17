package com.github.lazyf1sh.asanas;

import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.asanas.named.vasisthasana.VasisthasanaLegsCrossed.vasisthasanaLegsCrossed;
import static com.github.lazyf1sh.asanas.named.vasisthasana.VasisthasanaLegsExtended.vasisthasanaLegExtended;
import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static com.github.lazyf1sh.util.Util.convertToRu;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringContains.containsString;

public class VasisthasanaLegsCrossedTest
{

    @Test
    public void legsCrossed() throws IOException
    {
        // when
        String result = convertToRu(vasisthasanaLegsCrossed());

        // then
        assertThat(result.length(), equalTo(434));
        assertThat(result, containsString("Поза Мудреца Вас+иштхи или поза боковой планки"));
        containsNoCurlyBrackets(result);
    }

    @Test
    public void should_expected_result() throws IOException
    {
        // when
        String result = convertToRu(vasisthasanaLegExtended());


        // then
        assertThat(result.length(), equalTo(199));
        assertThat(result, containsString("Анантан+асана."));
        containsNoCurlyBrackets(result);
    }
}