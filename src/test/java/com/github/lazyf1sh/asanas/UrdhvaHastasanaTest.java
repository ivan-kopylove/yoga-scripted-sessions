package com.github.lazyf1sh.asanas;

import com.github.lazyf1sh.asanas.urdhvaHastasana.UrdhvaHastasana;
import com.github.lazyf1sh.util.YogaConfig;
import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class UrdhvaHastasanaTest {


    @Test
    public void replaced_with_meaning() throws IOException {
        // given
        final YogaConfig yogaConfig = new YogaConfig();
        yogaConfig.setSanscritMeaning(true);
        yogaConfig.setLanguage("ru");

        // when
        final String result = new UrdhvaHastasana(yogaConfig).build();

        // then
        assertThat(result.length(), equalTo(485));
        assertThat(result.lines().count(), equalTo(21L));
        assertThat(result, containsString("+Урдхва - верх. Хаста – рука."));
        containsNoCurlyBrackets(result);
    }


    @Test
    public void replaced_with_no_meaning() throws IOException {
        // given
        final YogaConfig yogaConfig = new YogaConfig();
        yogaConfig.setSanscritMeaning(false);
        yogaConfig.setLanguage("ru");

        // when
        final String result = new UrdhvaHastasana(yogaConfig).build();

        // then
        assertEquals(456, result.length());
        containsNoCurlyBrackets(result);
    }


}