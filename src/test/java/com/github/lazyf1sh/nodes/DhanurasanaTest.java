package com.github.lazyf1sh.nodes;

import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.nodes.danayamanaDhanurasana.DanayamanaDhanurasana.danayamanaDhanurasana;
import static com.github.lazyf1sh.nodes.dhanurasana.Dhanurasana.dhanurasana;
import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static com.github.lazyf1sh.util.Util.convertToRu;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class DhanurasanaTest {

    @Test
    public void should_be_of_expected_length_and_contain_specific_values() throws IOException {
        // when
        final String result = convertToRu(dhanurasana());

        // then
        assertThat(result.length(), equalTo(494));

        containsNoCurlyBrackets(result);
    }

    @Test
    public void dandayamana_dhanurasana_ru() throws IOException {
        // when
        final String result = convertToRu(danayamanaDhanurasana());

        // then
        assertThat(result.length(), equalTo(290));

        containsNoCurlyBrackets(result);
    }


}