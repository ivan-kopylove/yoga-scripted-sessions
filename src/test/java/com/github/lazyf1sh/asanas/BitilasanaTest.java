package com.github.lazyf1sh.asanas;

import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.asanas.Bitilasana.bitilasana;
import static com.github.lazyf1sh.util.YogaConfig.yogaConfigRuWithMeaning;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class BitilasanaTest {

    @Test
    public void should_be_of_expected_length_ru() throws IOException {
        // when
        final String result = bitilasana(yogaConfigRuWithMeaning()).build();

        // then
        assertThat(result.length(), equalTo(405));
        assertThat(result.lines().count(), equalTo(15L));
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