package com.github.lazyf1sh.asanas;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ConvertJavaMapToJson
{

    @Test
    public void convertMapToJson() throws JsonProcessingException
    {
        final Map<String, String> elements = new HashMap();
        elements.put("Key1", "Value1");
        elements.put("Key2", "Value2");
        elements.put("Key3", "Value3");

        final ObjectMapper objectMapper = new ObjectMapper();

        final String json = objectMapper.writeValueAsString(elements);
        assertThat("{\"Key2\":\"Value2\",\"Key1\":\"Value1\",\"Key3\":\"Value3\"}", equalTo(json));
    }
}