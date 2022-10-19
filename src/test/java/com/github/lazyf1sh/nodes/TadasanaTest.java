package com.github.lazyf1sh.nodes;

import com.github.lazyf1sh.nodes.tadasana.Tadasana;

import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.nodes.tadasana.Tadasana.quickTadasana;

import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TadasanaTest {

    @Test
    public void should_be_of_expected_length() throws IOException {
        // given


        // when
        final String result = new Tadasana().palmsInNamaste();

        // then
        assertThat(result.length(), equalTo(747));
    }

    @Test
    public void should_contain_asana_name() throws IOException {
        // given

        // when
        final String result = quickTadasana();

        // then
        assertThat(result, containsString("Тад+асана."));
    }

    @Test
    public void should_contain_asana_name_ru() throws IOException {
        // given


        // when
        final String result = new Tadasana().palmsInNamaste();


        // then
        assertThat(result, containsString("Тад+асана."));
        assertThat(result, containsString("Поза горы."));
        assertThat(result, containsString("Вариант с кистями, сложенными в намасте."));
        containsNoCurlyBrackets(result);
    }


}