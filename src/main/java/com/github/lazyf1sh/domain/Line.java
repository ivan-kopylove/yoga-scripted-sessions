package com.github.lazyf1sh.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.github.ivan.kopylove.commons.stream.StreamUtil.shuffleComparator;
import static com.github.lazyf1sh.domain.LineLanguage.EN;
import static com.github.lazyf1sh.domain.LineLanguage.RU;
import static com.github.lazyf1sh.domain.LineLanguage.UNKNOWN;
import static com.github.lazyf1sh.domain.LineType.REGULAR;
import static com.github.lazyf1sh.domain.LineType.SILENCE;

public class Line
{
    private static final Logger       LOGGER       = LoggerFactory.getLogger(Line.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private ObjectNode node;
    private int        pauseDuration;
    private LineType   lineType;

    public Line(ObjectNode node, int pauseDuration, LineType lineType)
    {
        this.node = node;
        this.pauseDuration = pauseDuration;
        this.lineType = lineType;
    }

    public Line(String line) throws JsonProcessingException
    {
        node = objectMapper.readValue(line, ObjectNode.class);

        JsonNode sil = node.get("silence");
        if (sil != null)
        {
            lineType = SILENCE;
            pauseDuration = sil.asInt();
            return;
        }

        if (ru() != null)
        {
            lineType = REGULAR;
        }
    }

    public int getPauseDuration()
    {
        return pauseDuration;
    }

    public LineType getLineType()
    {
        return lineType;
    }

    public boolean isRegularLine()
    {
        return lineType.isRegularLine();
    }


    public Optional<String> ru()
    {
        JsonNode node = this.node.get("ru");
        if (node != null)
        {
            return Optional.of(node.asText());
        }
        return Optional.empty();
    }

    public double chance()
    {
        if (node != null)
        {
            JsonNode chance = node.get("chance");
            if (chance != null)
            {
                return chance.asDouble();
            }
        }
        return 100;
    }

    public LineLanguage lineLanguage()
    {
        if (en().isPresent())
        {
            return EN;
        }
        if (ru() != null)
        {
            return RU;
        }
        return UNKNOWN;
    }

    public String getNodeText()
    {
        if (node == null)
        {
            throw new RuntimeException("Node is null");
        }
        return node.asText();
    }


    public Optional<String> getLineByLanguage(LineLanguage language)
    {
        if (node == null)
        {
            return Optional.empty();
        }
        switch (language)
        {
            case EN ->
            {
                return en();
            }
            case RU ->
            {
                return ru();
            }

        }

        throw new RuntimeException("getLineByLanguage");
    }


    public Optional<String> en()
    {
        if (node == null)
        {
            return Optional.empty();
        }
        JsonNode en = node.get("en");
        JsonNode enSynonyms = node.get("enSynonyms");

        if (enSynonyms != null)
        {
            List<JsonNode> list = StreamSupport
                    .stream(enSynonyms.spliterator(), false)
                    .collect(Collectors.toList());
            if (null != en)
            {
                list.add(en);
            }
            return list.stream()
                       .sorted(shuffleComparator())
                       .findFirst()
                       .map(JsonNode::asText);
        }

        if (null == en)
        {
            return Optional.empty();
        }
        return Optional.of(en.asText());
    }
}
