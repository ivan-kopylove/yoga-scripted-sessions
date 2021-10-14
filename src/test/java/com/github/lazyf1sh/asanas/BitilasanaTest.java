package com.github.lazyf1sh.asanas;

import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.asanas.bitilasana.Bitilasana.bitilasana;
import static com.github.lazyf1sh.test.fixtures.YogaConfigTestFixtures.yogaConfigRuWithMeaning;
import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static com.github.lazyf1sh.util.CommonAssertion.containsNoWords;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class BitilasanaTest {

    @Test
    public void should_draw_attention_when_length_has_changed() throws IOException {
        // when
        final String result = bitilasana(yogaConfigRuWithMeaning()).build();

        // then
        assertThat(result.length(), equalTo(350));
        assertThat(result.lines().count(), equalTo(16L));
    }

    @Test
    public void should_pass_generic_check() throws IOException {
        // when
        final String result = bitilasana(yogaConfigRuWithMeaning()).build();

        // then
        containsNoCurlyBrackets(result);
        containsNoWords(result);
    }

    @Test
    public void should_contain_asana_name_ru() throws IOException {
        // when
        final String result = bitilasana(yogaConfigRuWithMeaning()).build();
        // then
        assertThat(result, containsString("Поза коровы"));
        assertThat(result, containsString("Битиласана"));
    }
}