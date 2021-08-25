package com.github.lazyf1sh;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class BendsBuilderTest {

    @Test
    public void should_be_of_expected_length() throws IOException {
        BendsBuilder bendsBuilder = new BendsBuilder();
        String result = bendsBuilder.buildBendsSession();

        assertEquals(result.length(), 42252);
    }

}