package com.github.lazyf1sh.util;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.IOException;

public class PauseConverterTest {

    @Test
    public void adfa() throws IOException {
String test = "Обе стопы отведите назад.\n" +
        "sil<[7000]>\n" +
        "Колени опустите.\n" +
        "sil<[8000]>";

        PauseConverter pauseConverter = new PauseConverter();
        pauseConverter.distributePause(test);

    }
}