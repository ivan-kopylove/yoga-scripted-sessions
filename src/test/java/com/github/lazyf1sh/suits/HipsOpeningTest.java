package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.util.YogaConfig;
import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class HipsOpeningTest {

    @Test
    public void should_be_of_expected_size() throws IOException {
        final YogaConfig yogaConfig = new YogaConfig(true, "ru");
        final HipsOpening hipsOpening = new HipsOpening(yogaConfig);

        final String result = hipsOpening.buildHipsOpeningSession();

        assertThat(result.length(), equalTo(45473));
        assertThat(result.lines().count(), equalTo(2095L));
        assertThat(result, containsString("Урдхва хастасана на носках"));
        containsNoCurlyBrackets(result);
    }
}