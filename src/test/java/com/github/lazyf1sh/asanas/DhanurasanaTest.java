package com.github.lazyf1sh.asanas;

import com.github.lazyf1sh.util.YogaConfig;
import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class DhanurasanaTest {

    @Test
    public void should_be_of_expected_length_and_contain_specific_values() throws IOException {
        // when
        final String result = new Dhanurasana(new YogaConfig(true, "ru")).build();

        // then
        assertThat(result.length(), equalTo(547));
        assertThat(result.lines().count(), equalTo(25L));
        assertThat(result, containsString("Дханур+асана."));
        assertThat(result, containsString("Поза лука."));

        containsNoCurlyBrackets(result);
    }

    @Test
    public void dandayamana() throws IOException {
        // when
        final String result = new Dhanurasana(new YogaConfig(true, "ru")).dandayamana();

        // then
        assertThat(result.length(), equalTo(319));
        assertThat(result.lines().count(), equalTo(14L));
        assertThat(result, containsString("Дандаямана"));
        assertThat(result, containsString("дханур+асана."));
        assertThat(result, containsString("Поза вытянутого лука."));

        containsNoCurlyBrackets(result);
    }


}