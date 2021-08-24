package com.github.lazyf1sh;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class HipsOpeningBuilderTest {

    private HipsOpeningBuilder hipsOpeningBuilder = new HipsOpeningBuilder();

    @Test
    public void run() throws IOException {
        String text = hipsOpeningBuilder.buildHipsOpeningSession();
        assertEquals(text.length(), 45484);
    }
}