package com.github.lazyf1sh.nodes;

import com.github.lazyf1sh.nodes.shalabhasana.Shalabhasana;
import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static com.github.lazyf1sh.util.Util.convertToRu;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ShalabhasanaTest {

    @Test
    public void ru_length_check() throws IOException {
        // when
        final String result = convertToRu(new Shalabhasana().build());

        // then
        assertThat(result.length(), equalTo(215));
    }

    @Test
    public void should_contain_asana_name_ru() throws IOException {
        // given


        // when
        final String result = convertToRu(new Shalabhasana().build());

        // then
        assertThat(result, containsString("Шалабх+асана."));
        assertThat(result, containsString("Поза Саранчи."));
        containsNoCurlyBrackets(result);
    }
}