package com.github.lazyf1sh.asanas;

import com.github.lazyf1sh.YogaConfig;
import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.asanas.CommonAssertion.containsNoCurlyBrackets;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UrdhvaHastasanaTest {


    @Test
    public void replaced_with_meaning() throws IOException {
        // given
        YogaConfig yogaConfig = new YogaConfig();
        yogaConfig.setSanscritMeaning(true);
        yogaConfig.setLanguage("ru");

        // when
        String result = new UrdhvaHastasana(yogaConfig).buildUrdhvaHastasana();

        // then
        assertEquals(485, result.length());
        assertTrue(result.contains("+Урдхва - верх. Хаста – рука."));
        containsNoCurlyBrackets(result);
    }


    @Test
    public void replaced_with_no_meaning() throws IOException {
        // given
        YogaConfig yogaConfig = new YogaConfig();
        yogaConfig.setSanscritMeaning(false);
        yogaConfig.setLanguage("ru");

        // when
        String result = new UrdhvaHastasana(yogaConfig).buildUrdhvaHastasana();

        // then
        assertEquals(456, result.length());
        containsNoCurlyBrackets(result);
    }


}