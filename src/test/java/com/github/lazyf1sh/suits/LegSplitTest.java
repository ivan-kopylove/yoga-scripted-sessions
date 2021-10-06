package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.util.YogaConfig;
import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.suits.LegSplit.legSplitSession;
import static com.github.lazyf1sh.test.fixtures.YogaConfigTestFixtures.yogaConfigRuWithMeaning;
import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static com.github.lazyf1sh.util.CommonAssertion.containsNoWords;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class LegSplitTest implements SuiteTest {

    @Test
    public void should_be_of_expected_length_ru() throws IOException {
        // given
        final YogaConfig yogaConfig = yogaConfigRuWithMeaning();

        // when
        final String result = legSplitSession(yogaConfig);

        // then
        assertThat(result.length(), equalTo(11019));
        assertThat(result.lines().count(), equalTo(479L));

    }

    @Test
    public void should_contain_specific_lines_ru() throws IOException {
        // given
        final YogaConfig yogaConfig = yogaConfigRuWithMeaning();

        // when
        final String result = legSplitSession(yogaConfig);


        // then
        assertThat(result, containsString("Хаста уттан+асана"));
        assertThat(result, containsString("Прогиб из положения стоя"));
    }

    @Override
    public void should_pass_generic_checks_ru() throws IOException {
        // given
        final YogaConfig yogaConfig = yogaConfigRuWithMeaning();

        // when
        final String result = legSplitSession(yogaConfig);

        // then
        containsNoCurlyBrackets(result);
        containsNoWords(result);
    }

}