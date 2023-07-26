package com.github.lazyf1sh.asanas;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.json.compare.JSONCompare.assertMatches;

public class ConvertJavaMapToJsonTest
{
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void convertMapToJson() throws JsonProcessingException
    {
        Map<String, String> elements = new HashMap<>();
        elements.put("Key1", "Value1");
        elements.put("Key2", "Value2");
        elements.put("Key3", "Value3");

        String json = objectMapper.writeValueAsString(elements);

        assertMatches("""
                              {
                                "Key2": "Value2",
                                "Key1": "Value1",
                                "Key3": "Value3"
                              }
                              """, json);
    }
}