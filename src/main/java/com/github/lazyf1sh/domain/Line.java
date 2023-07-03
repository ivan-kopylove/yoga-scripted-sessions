package com.github.lazyf1sh.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import static com.github.lazyf1sh.domain.LineType.PAUSE;
import static com.github.lazyf1sh.domain.LineType.REGULAR;
import static com.github.lazyf1sh.util.PauseConverter.SIL;

public class Line {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private ObjectNode node;
    private int pauseDuration;
    private LineType lineType;

    public Line(String line) throws JsonProcessingException {

        this.lineType = line.startsWith(SIL) ? PAUSE : REGULAR;
        switch (lineType)
        {
            case REGULAR:
                node = objectMapper.readValue(line, ObjectNode.class);
                break;
            case PAUSE:
                pauseDuration = Integer.parseInt(line.split("\\[")[1].split("\\]")[0]);
                break;
        }


    }

    public String ru() {
        return node.get("ru").asText();
    }
}
