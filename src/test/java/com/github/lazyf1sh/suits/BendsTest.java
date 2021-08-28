package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.util.YogaConfig;
import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BendsTest {

    @Test
    public void should_be_of_expected_length_ru() throws IOException {
        final YogaConfig yogaConfig = new YogaConfig();
        yogaConfig.setSanscritMeaning(true);
        yogaConfig.setLanguage("ru");

        final Bends bends = new Bends(yogaConfig);
        final String result = bends.buildBendsSession();

        assertEquals(42246, result.length());
        assertTrue(result.contains("Урдхва хастасана на носках"));
        containsNoCurlyBrackets(result);
    }

}