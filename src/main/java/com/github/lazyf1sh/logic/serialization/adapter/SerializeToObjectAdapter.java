package com.github.lazyf1sh.logic.serialization.adapter;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.github.lazyf1sh.logic.serialization.spi.SerializeToObjectSpi;
import com.github.lazyf1sh.logic.serialization.spi.ToStringSerializerSpi;
import com.sun.jdi.ObjectReference;

import static com.github.ivan.kopylove.commons.serialization.CommonSerializationConfig.getCommonSerializer;

public class SerializeToObjectAdapter implements SerializeToObjectSpi {

    @Override
    public <T> T deserialize(Payload myPayload) {

        try {
            return getCommonSerializer().readValue(myPayload.json(), new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
