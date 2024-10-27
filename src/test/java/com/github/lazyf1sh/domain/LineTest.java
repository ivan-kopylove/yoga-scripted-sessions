package com.github.lazyf1sh.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class LineTest
{
    @Test
    public void run() throws JsonProcessingException
    {
        String line = """
                { "ru": "Поза ребенка.", "chance": 90}
                """;


        Line lineObj = new Line(line);

        assertThat(lineObj.chance(), equalTo(97.2));
    }
}