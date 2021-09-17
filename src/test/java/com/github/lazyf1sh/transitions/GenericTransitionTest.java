package com.github.lazyf1sh.transitions;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;

import static com.github.lazyf1sh.transitions.GenericTransition.genericTransition;
import static com.github.lazyf1sh.util.YogaConfig.yogaConfigRuWithMeaning;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class GenericTransitionTest {

    @Test
    public void should_expected_result() throws IOException {
        // when
        final String result = genericTransition(yogaConfigRuWithMeaning(), Paths.get("d856222abcd5"));

        // then
        assertThat(result, containsString("Сделайте пружину 6 раз."));
    }
}