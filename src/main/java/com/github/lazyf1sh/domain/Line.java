package com.github.lazyf1sh.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Line {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private final ObjectNode node;

    public Line(String line) throws JsonProcessingException {
        node = objectMapper.readValue(line, ObjectNode.class);
    }

    public String ru() {
        return node.get("ru").asText();
    }
}
