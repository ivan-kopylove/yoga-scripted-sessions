package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.util.YogaConfig;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class DisclaimerTest {

    @Test
    public void should_expected_result() throws IOException {
        // given
        final YogaConfig yogaConfig = new YogaConfig(true, "ru");


        // when
        final String result = new Disclaimer(yogaConfig).build();

        // then
        assertThat(result.length(), equalTo(329));
        assertThat(result.lines().count(), equalTo(11L));
    }

    @Test
    public void should_contain_warnings() throws IOException {
        // given
        final YogaConfig yogaConfig = new YogaConfig(true, "ru");


        // when
        final String result = new Disclaimer(yogaConfig).build();

        // then
        assertThat(result.length(), equalTo(329));
        assertThat(result.lines().count(), equalTo(11L));
        assertThat(result, containsString("При боли прекратите занятие."));
        assertThat(result, containsString("Самостоятельная практика бесполезна и даже разрушительна."));
    }


}