package com.github.lazyf1sh.asanas.ashtangaNamaskara;

import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.test.fixtures.YogaConfigTestFixtures.yogaConfigRuWithMeaning;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class AshtangaNamaskaraTest  {

    @Test
    public void should_draw_attention_when_length_has_changed() throws IOException {
        // when
        final String result = new AshtangaNamaskara(yogaConfigRuWithMeaning()).build();

        // then
        assertThat(result.length(), equalTo(280));
    }

}