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
    public void dandayamana_dhanurasana_ru() throws IOException {
        // when
        final String result = new Dhanurasana(new YogaConfig(true, "ru")).dandayamana();

        // then
        assertThat(result.length(), equalTo(396));
        assertThat(result.lines().count(), equalTo(15L));
        assertThat(result, containsString("Дандаямана"));
        assertThat(result, containsString("дханур+асана."));
        assertThat(result, containsString("Поза вытянутого лука."));
        assertThat(result, containsString("Данда - палка, посох."));
        assertThat(result, containsString("+Ямана - баланс или поддержание."));
        assertThat(result, containsString("Дхану означает лук."));

        containsNoCurlyBrackets(result);
    }

    @Test
    public void dandayamana_dhanurasana_en() throws IOException {
        // when
        final String result = new Dhanurasana(new YogaConfig(true, "en")).dandayamana();

        // then
        assertThat(result.length(), equalTo(99));
        assertThat(result.lines().count(), equalTo(2L));
        assertThat(result, containsString("Danda - means stick or staff."));
        assertThat(result, containsString("Yamana - means balancing or maintaining."));
        assertThat(result, containsString("Dhanu means bow."));

        containsNoCurlyBrackets(result);
    }


}