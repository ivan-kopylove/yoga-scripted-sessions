package com.github.lazyf1sh.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Line {

    private final ObjectNode node;

    public Line(String line) throws JsonProcessingException {
        node = new ObjectMapper().readValue(line, ObjectNode.class);
    }

    public String ru()
    {
        return node.get("ru").asText();
    }
}
