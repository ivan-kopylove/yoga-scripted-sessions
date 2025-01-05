package com.github.lazyf1sh.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import com.github.lazyf1sh.logic.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.github.ivan.kopylove.commons.stream.StreamUtil.shuffleComparator;
import static com.github.lazyf1sh.domain.LineLanguage.*;
import static com.github.lazyf1sh.domain.LineType.*;
import org.slf4j.*;

public class Line {
    private static final Logger LOGGER = LoggerFactory.getLogger(Line.class);
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

        JsonNode sil = node.get("silence");
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
        JsonNode node = this.node.get("ru");
        if (node != null) {
            return node.asText();
        }
        return null;
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
        JsonNode en = node.get("en");

        JsonNode enSynonyms = node.get("enSynonyms");



        if (enSynonyms != null) {
            List<JsonNode> list = StreamSupport
                    .stream(enSynonyms.spliterator(), false)
                    .collect(Collectors.toList());
            if (null != en) {
                list.add(en);
            }
            return list.stream()
                    .sorted(shuffleComparator())
                    .findFirst()
                    .map(JsonNode::asText);
        }

        if (null == en) {
            return Optional.empty();
        }
        return Optional.of(en.asText());
    }
}
