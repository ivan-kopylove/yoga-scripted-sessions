package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.util.YogaConfig;
import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.test.fixtures.YogaConfigTestFixtures.yogaConfigRuWithMeaning;
import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static com.github.lazyf1sh.util.CommonAssertion.containsNoWords;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class BendsTest {

    @Test
    public void should_draw_attention_when_length_has_changed() throws IOException {
        final Bends bends = new Bends(yogaConfigRuWithMeaning());
        final String result = bends.build();

        assertThat(result.length(), equalTo(43567));

    }

    @Test
    public void should_contain_specific_lines_for_russian_version() throws IOException {
        final Bends bends = new Bends(yogaConfigRuWithMeaning());
        final String result = bends.build();

        assertThat(result, containsString("Урдхва хаст+асана на носках"));
        assertThat(result, containsString("Дандаямана"));
        assertThat(result, containsString("дханур+асана."));
        assertThat(result, containsString("Поза вытянутого лука."));
        assertThat(result, containsString("Макар+асана."));
        assertThat(result, containsString("Поза крокодила."));


        containsNoWords(result);
        containsNoCurlyBrackets(result);
    }

}