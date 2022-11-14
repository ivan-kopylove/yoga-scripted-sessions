package com.github.lazyf1sh.suits;


import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.suits.LegSplit.legSplitSession;

import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static com.github.lazyf1sh.util.CommonAssertion.containsNoWords;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class LegSplitTest implements SuiteTest {

    @Test
    public void should_draw_attention_when_length_has_changed() throws IOException {
        // when
        final String result = legSplitSession();

        // then
        assertThat(result.length(), equalTo(11121));
    }

    @Test
    public void should_contain_specific_lines_ru() throws IOException {
        // when
        final String result = legSplitSession();

        // then
        assertThat(result, containsString("Хаста уттан+асана"));
        assertThat(result, containsString("Прогиб из положения стоя"));
    }

    @Override
    public void should_pass_generic_checks_ru() throws IOException {
        // when
        final String result = legSplitSession();

        // then
        containsNoCurlyBrackets(result);
        containsNoWords(result);
    }

}