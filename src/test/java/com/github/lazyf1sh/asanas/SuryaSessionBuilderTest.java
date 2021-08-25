package com.github.lazyf1sh.asanas;

import com.github.lazyf1sh.YogaConfig;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class SuryaSessionBuilderTest {
    @Test
    public void should_expected_result() throws IOException {
        // given
        YogaConfig yogaConfig = new YogaConfig();
        yogaConfig.setSanscritMeaning(true);
        yogaConfig.setLanguage("ru");

        // when
        String result = new SuryaSessionBuilder(yogaConfig).buildSuryaSession();

        // then
        assertEquals(53696, result.length());
    }
}