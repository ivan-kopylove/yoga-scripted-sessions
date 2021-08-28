package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.util.YogaConfig;
import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class BendsTest {

    @Test
    public void should_be_of_expected_length_ru() throws IOException {
        final YogaConfig yogaConfig = new YogaConfig();
        yogaConfig.setSanscritMeaning(true);
        yogaConfig.setLanguage("ru");

        final Bends bends = new Bends(yogaConfig);
        final String result = bends.build();

        assertThat(result.length(), equalTo(42098));
        assertThat(result.lines().count(), equalTo(1852L));
        assertThat(result, containsString("Урдхва хастасана на носках"));
        containsNoCurlyBrackets(result);
    }

    @Test
    public void should_contain_specific_lines_ru() throws IOException {
        final YogaConfig yogaConfig = new YogaConfig();
        yogaConfig.setSanscritMeaning(true);
        yogaConfig.setLanguage("ru");

        final Bends bends = new Bends(yogaConfig);
        final String result = bends.build();

        assertThat(result, containsString("Урдхва хастасана на носках"));

        assertThat(result, containsString("Дандаямана"));
        assertThat(result, containsString("дханур+асана."));
        assertThat(result, containsString("Поза вытянутого лука."));

        containsNoCurlyBrackets(result);
    }

}