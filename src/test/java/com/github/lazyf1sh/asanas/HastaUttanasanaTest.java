package com.github.lazyf1sh.asanas;

import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.asanas.HastaUttanasana.hastaUttanasana;
import static com.github.lazyf1sh.test.fixtures.YogaConfigTestFixtures.yogaConfigRuWithMeaning;

public class HastaUttanasanaTest {

    @Test
    public void should_expected_result() throws IOException {
        // given

        // when

        // then
        hastaUttanasana(yogaConfigRuWithMeaning());
    }

}