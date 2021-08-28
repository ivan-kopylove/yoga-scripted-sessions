package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.util.YogaConfig;
import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HipsOpeningTest {

    @Test
    public void run() throws IOException {
        final YogaConfig yogaConfig = new YogaConfig(true, "ru");
        final HipsOpening hipsOpening = new HipsOpening(yogaConfig);

        final String result = hipsOpening.buildHipsOpeningSession();

        assertEquals(45464, result.length());
        assertTrue(result.contains("Урдхва хастасана на носках"));
        containsNoCurlyBrackets(result);
    }
}