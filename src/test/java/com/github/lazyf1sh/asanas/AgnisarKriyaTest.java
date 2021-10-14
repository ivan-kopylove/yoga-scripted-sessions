package com.github.lazyf1sh.asanas;

import com.github.lazyf1sh.asanas.agnisarKriya.AgnisarKriya;
import com.github.lazyf1sh.util.YogaConfig;
import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.test.fixtures.YogaConfigTestFixtures.yogaConfigRuWithMeaning;
import static com.github.lazyf1sh.util.CommonAssertion.allCommonChecks;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class AgnisarKriyaTest {

    @Test
    public void should_draw_attention_when_size_has_changed() throws IOException {
        // given
        final YogaConfig ru = new YogaConfig(true, "ru");
        // when

        final String result = new AgnisarKriya(ru).build();

        // then
        assertThat(result.length(), equalTo(883));
        assertThat(result.lines().count(), equalTo(40L));
    }

    @Test
    public void should_contain_asana_name_ru() throws IOException {
        // given
        final YogaConfig ru = new YogaConfig(true, "ru");
        // when

        final String result = new AgnisarKriya(ru).build();

        // then
        assertThat(result, containsString("Агнисара Дхаути Крийя."));
        assertThat(result, containsString("Очищение внутренним огнём."));
    }

    @Test
    public void should_pass_generic_check_ru() throws IOException {
        // then
        final YogaConfig yogaConfig = yogaConfigRuWithMeaning();

        final String result = new AgnisarKriya(yogaConfig).build();

        allCommonChecks(result, AgnisarKriya.class, yogaConfig);
    }


}