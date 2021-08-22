package com.github.lazyf1sh.asanas;

import com.github.lazyf1sh.YogaConfig;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

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
        assertEquals(result.length(), 488);
        assertTrue(result.contains("+Урдхва - верхний. Хаста – рука."));
        containsNoCurlyBrackets(result);
    }

    private void containsNoCurlyBrackets(String result) {
        assertFalse(result.contains("{{"));
        assertFalse(result.contains("}}"));
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
        assertEquals(result.length(), 456);
        containsNoCurlyBrackets(result);
    }


}