package com.github.lazyf1sh.util;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static com.github.lazyf1sh.util.TextSplitter.DEFAULT_CHUNK_SIZE;
import static java.util.Objects.requireNonNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TextSplitterTest {

    private final TextSplitter textSplitter = new TextSplitter();


    @Test
    public void should_split() {
        // when
        List<String> result = textSplitter.split("hello world");

        // then
        assertEquals(1, result.size());
        assertEquals(11, result.get(0).length());
        commonAssertion(result);
    }


    @Test
    public void should_be_of_expected_result_for_lorem_ipsum_1() throws IOException {
        // given
        String resourceName = "lorem_ipsum_01";

        String inputText = readTestFile(resourceName);


        // when
        List<String> result = textSplitter.split(inputText);

        // then
        assertEquals(1, result.size());
        assertEquals(3647, inputText.length());
        commonAssertion(result);
        commonDotAssertion(result);
    }

    @Test
    public void should_be_of_expected_result_for_lorem_ipsum_2() throws IOException {
        // given
        String resourceName = "lorem_ipsum_02";

        String inputText = readTestFile(resourceName);


        // when
        List<String> result = textSplitter.split(inputText);

        // then
        assertEquals(30764, inputText.length());
        assertEquals(7, result.size());
        commonAssertion(result);
        commonDotAssertion(result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_be_of_expected_result_for_lorem_ipsum_3_no_dots() throws IOException {
        // given
        String resourceName = "lorem_ipsum_03";

        String inputText = readTestFile(resourceName);


        // when
        List<String> result = textSplitter.split(inputText);

        // then
        assertEquals("inputText", 30196, inputText.length());
        assertEquals(7, result.size());
        commonAssertion(result);

    }


    private String readTestFile(String resourceName) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        Path file = new File(requireNonNull(classLoader.getResource(resourceName)).getPath()).toPath();
        return Files.readString(file);
    }


    private void commonAssertion(List<String> result) {
        result.forEach(s -> assertTrue(s.length() <= DEFAULT_CHUNK_SIZE));
    }

    private void commonDotAssertion(List<String> result) {
        result.forEach(s -> assertTrue(s.trim().endsWith(".")));
    }


    @Test(expected = IllegalArgumentException.class)
    public void should_throw_for_zero_length_content() {
        // then
        textSplitter.split("");
    }


}