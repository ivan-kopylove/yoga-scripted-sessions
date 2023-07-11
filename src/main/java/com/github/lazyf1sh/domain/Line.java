package com.github.lazyf1sh.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.lazyf1sh.yandex.speech.api.Voice;

import java.util.Optional;

import static com.github.lazyf1sh.domain.LineType.*;
import static com.github.lazyf1sh.util.PauseConverter.CLOSING_BRACKET;
import static com.github.lazyf1sh.util.PauseConverter.SIL;
import static com.github.lazyf1sh.yandex.speech.api.Voice.PREVIOUS;

public class Line {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private ObjectNode node;
    private int pauseDuration;
    private LineType lineType;

    public Line(String line) throws JsonProcessingException {

        if (line.startsWith(SIL)) {
            lineType = PAUSE;
        } else {
            node = objectMapper.readValue(line, ObjectNode.class);
            if (switchRuMainVoice() != PREVIOUS) {
                lineType = VOICE_SWITCH;
            } else {
                if (ru() != null) {
                    lineType = REGULAR;
                }
            }
        }


        switch (lineType) {
            case REGULAR:

                break;
            case PAUSE:
                pauseDuration = Integer.parseInt(line.split("\\[")[1].split("\\]")[0]);
                break;
        }

    }


    public int getPauseDuration() {
        return pauseDuration;
    }

    public Voice switchRuMainVoice() {
        return Optional.ofNullable(node)
                .map(node -> node.get("switchRuMainVoice"))
                .map(JsonNode::asText)
                .map(Voice::valueOf)
                .orElse(PREVIOUS);
    }

    public String getJson() {
        if (node != null) {
            return node.toString();
        } else {
            return SIL + pauseDuration + CLOSING_BRACKET;
        }

    }

    public LineType getLineType() {
        return lineType;
    }

    public void put(String key, String val) {
        node.put(key, val);
    }

    public Optional<String> ruOrPause() {

        switch (lineType) {
            case REGULAR:
                return Optional.of(node.get("ru").asText());
            case PAUSE:
                return Optional.of(SIL + pauseDuration + CLOSING_BRACKET);
        }

        throw new RuntimeException();
    }

    public String ru() {
        return node.get("ru").asText();
    }

    public double chance() {
        if(node != null) {
            JsonNode chance = node.get("chance");
            if (chance != null) {
                return chance.asDouble();
            }
        }
        return 100;
    }


    public Optional<String> en() {
        JsonNode val = node.get("en");
        if (null == val) {
            return Optional.empty();
        }
        return Optional.of(val.asText());
    }

    public Optional<String> de() {
        JsonNode val = node.get("de");
        if (null == val) {
            return Optional.empty();
        }
        return Optional.of(val.asText());
    }


}
