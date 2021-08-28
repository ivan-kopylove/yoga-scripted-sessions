package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.util.YogaConfig;
import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SuryaNamaskarTest {
    @Test
    public void all_assertions() throws IOException {
        // given
        final YogaConfig yogaConfig = new YogaConfig();
        yogaConfig.setSanscritMeaning(true);
        yogaConfig.setLanguage("ru");

        // when
        final String result = new SuryaNamaskar(yogaConfig).buildSuryaSession();

        // then
        assertEquals(53691, result.length());
        assertTrue(result.contains("Урдхва хастасана на носках"));
        containsNoCurlyBrackets(result);
    }
}