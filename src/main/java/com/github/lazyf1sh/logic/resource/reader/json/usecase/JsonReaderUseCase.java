package com.github.lazyf1sh.logic.resource.reader.json.usecase;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.lazyf1sh.domain.Line;
import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.logic.*;
import com.github.lazyf1sh.logic.resource.reader.json.api.JsonReaderApi;
import com.github.lazyf1sh.logic.serialization.spi.SerializeToObjectSpi;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.github.lazyf1sh.domain.LineType.REGULAR;
import static com.github.lazyf1sh.domain.LineType.SILENCE;
import org.slf4j.*;


public class JsonReaderUseCase implements JsonReaderApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonReaderUseCase.class);

    private final SerializeToObjectSpi deserializer;

    public JsonReaderUseCase(SerializeToObjectSpi deserializer) {
        this.deserializer = deserializer;
    }

    @Override
    public JsonReaderApi.Result readJsonResouce(Payload myPayload) {
        try {
            Class<?> clazz = myPayload.myPayload();
            String name = clazz.getSimpleName();

            URL resource = clazz.getResource(name + JSON_EXTENSION);
            if(resource == null) {
                LOGGER.error(name + " is null");
                Objects.requireNonNull(resource);
            }



            Path path = new File(resource.getPath()).toPath();

            String s = Files.readString(path);

            JsonNode node = deserializer.deserialize(new SerializeToObjectSpi.Payload<>(s, new TypeReference<>() {
            }));

            if (!node.isArray()) {
                throw new RuntimeException("is not array: " + node);
            }

            List<Line> lines = new ArrayList<>();
            SourceFile sourceFile = new SourceFile(name, lines);

            for (JsonNode element : node) {
                JsonNode sil = element.get("silence");
                if (sil != null) {
                    lines.add(new Line((ObjectNode) element, sil.asInt(), SILENCE));
                } else if (element.get("ru") != null) {
                    lines.add(new Line((ObjectNode) element, -1, REGULAR));
                }

            }


            return new Result.MySuccessResult(sourceFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static final String JSON_EXTENSION = ".json";
}
