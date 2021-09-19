package com.github.lazyf1sh.asanas;

import com.github.lazyf1sh.asanas.hastauttanasana.HastaUttanasana;
import com.github.lazyf1sh.util.YogaConfig;
import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.asanas.hastauttanasana.HastaUttanasana.hastaUttanasana;
import static com.github.lazyf1sh.test.fixtures.YogaConfigTestFixtures.yogaConfigRuWithMeaning;
import static com.github.lazyf1sh.util.CommonAssertion.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class HastaUttanasanaTestRu implements GenericRuAsanaTest {

    @Test
    public void should_be_of_expected_length_ru() throws IOException {
        // when
        final String result = hastaUttanasana(yogaConfigRuWithMeaning());

        // then
        assertThat(result.length(), equalTo(788));
        assertThat(result.lines().count(), equalTo(33L));
    }

    @Test
    public void should_contain_asana_name_ru() throws IOException {
        // when
        final String result = hastaUttanasana(yogaConfigRuWithMeaning());

        // then
        assertThat(result, containsString("Хаста уттан+асана."));
    }

    @Override
    public void should_contain_asana_meaning_ru() throws IOException {
        fail();
    }

    @Test
    public void should_pass_generic_check_ru() throws IOException {
        // when
        final YogaConfig yogaConfig = yogaConfigRuWithMeaning();
        final String result = hastaUttanasana(yogaConfig);

        // then
        containsNoCurlyBrackets(result);
        containsNoWords(result);
        shouldNotContainResourceBundleKeys(result, HastaUttanasana.class, yogaConfig);
    }

}