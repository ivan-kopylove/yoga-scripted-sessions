package com.github.lazyf1sh.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.github.ivan.kopylove.commons.stream.StreamUtil.shuffleComparator;
import static com.github.lazyf1sh.domain.LineLanguage.*;
import static com.github.lazyf1sh.domain.LineType.*;

public class Line {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private ObjectNode node;
    private int pauseDuration;
    private LineType lineType;

    public Line(ObjectNode node, int pauseDuration, LineType lineType) {
        this.node = node;
        this.pauseDuration = pauseDuration;
        this.lineType = lineType;
    }

    public Line(String line) throws JsonProcessingException {
        node = objectMapper.readValue(line, ObjectNode.class);

        JsonNode sil = node.get("sil");
        if (sil != null) {
            lineType = SILENCE;
            pauseDuration = sil.asInt();
            return;
        }

        if (ru() != null) {
            lineType = REGULAR;
        }
    }

    public int getPauseDuration() {
        return pauseDuration;
    }


    public LineType getLineType() {
        return lineType;
    }


    public String ru() {
        return node.get("ru").asText();
    }

    public double chance() {
        if (node != null) {
            JsonNode chance = node.get("chance");
            if (chance != null) {
                return chance.asDouble();
            }
        }
        return 100;
    }

    public LineLanguage lineLanguage() {
        if (en().isPresent()) {
            return EN;
        }
        if (ru() != null) {
            return RU;
        }
        return UNKNOWN;

    }

    public Optional<String> en() {
        JsonNode enSynonyms = node.get("enSynonyms");
        if (enSynonyms != null) {
            return StreamSupport.stream(enSynonyms.spliterator(), false).sorted(shuffleComparator()).findFirst().map(JsonNode::asText);

        }


        JsonNode val = node.get("en");
        if (null == val) {
            return Optional.empty();
        }
        return Optional.of(val.asText());
    }
}
