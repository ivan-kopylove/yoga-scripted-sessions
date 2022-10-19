package com.github.lazyf1sh.nodes;

import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.nodes.danayamanaDhanurasana.DanayamanaDhanurasana.danayamanaDhanurasana;
import static com.github.lazyf1sh.nodes.dhanurasana.Dhanurasana.dhanurasana;
import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class DhanurasanaTest {

    @Test
    public void should_be_of_expected_length_and_contain_specific_values() throws IOException {
        // when
        final String result = dhanurasana();

        // then
        assertThat(result.length(), equalTo(526));
        assertThat(result, containsString("Дханур+асана."));
        assertThat(result, containsString("Поза лука."));

        containsNoCurlyBrackets(result);
    }

    @Test
    public void dandayamana_dhanurasana_ru() throws IOException {
        // when
        final String result = danayamanaDhanurasana();

        // then
        assertThat(result.length(), equalTo(316));
        assertThat(result, containsString("Дандаямана"));
        assertThat(result, containsString("дханур+асана."));
        assertThat(result, containsString("Поза вытянутого лука."));

        containsNoCurlyBrackets(result);
    }



}