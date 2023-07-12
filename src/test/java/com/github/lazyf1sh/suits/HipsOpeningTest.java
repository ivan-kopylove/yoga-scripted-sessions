package com.github.lazyf1sh.suits;

import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.util.CommonAssertion.containsNoWords;
import static com.github.lazyf1sh.util.Util.convertToRu;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class HipsOpeningTest
{

    @Test
    public void should_be_of_expected_size() throws IOException
    {
        // given
        final String hipsOpening = convertToRu(new HipsOpening().build());


        // then
        assertThat(hipsOpening.length(), equalTo(31210));
    }

    @Test
    public void should_contain_specific_lines() throws IOException
    {
        // given
        final String hipsOpening = convertToRu(new HipsOpening().build());

        // then
        assertThat(hipsOpening, containsString("Урдхва хаст+асана на носках"));
        containsNoWords(hipsOpening);
    }
}