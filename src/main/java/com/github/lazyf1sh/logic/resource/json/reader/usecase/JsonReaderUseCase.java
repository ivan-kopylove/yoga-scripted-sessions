package com.github.lazyf1sh.logic.resource.json.reader.usecase;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.lazyf1sh.logic.resource.json.reader.api.JsonReaderApi;
import com.github.lazyf1sh.logic.serialization.spi.SerializeToObjectSpi;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;


public class JsonReaderUseCase implements JsonReaderApi {

    private final SerializeToObjectSpi deserializer;

    public JsonReaderUseCase(SerializeToObjectSpi deserializer) {
        this.deserializer = deserializer;
    }

    @Override
    public JsonReaderApi.Result readJsonAsanaResouce(Payload myPayload) {
        try {
            Class<?> clazz = myPayload.myPayload();
            String name = clazz.getSimpleName();

            URL resource = clazz.getResource(name + JSON_EXTENSION);

            Objects.requireNonNull(resource);

            Path path = new File(resource.getPath()).toPath();

            String s = Files.readString(path);

            JsonNode node = deserializer.deserialize(new SerializeToObjectSpi.Payload(s, new TypeReference<JsonNode>() {
            }));

            return new Result.MySuccessResult(List.of());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static final String JSON_EXTENSION = ".json";
}
