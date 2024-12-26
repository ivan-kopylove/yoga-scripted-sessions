package com.github.lazyf1sh.logic.serialization.adapter;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.lazyf1sh.logic.Cache;
import com.github.lazyf1sh.logic.serialization.spi.SerializeToObjectSpi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.github.ivan.kopylove.commons.serialization.CommonSerializationConfig.getCommonSerializer;

public class SerializeToObjectAdapter implements SerializeToObjectSpi {

    private static final Logger LOGGER = LoggerFactory.getLogger(Cache.class);

    @Override
    public <T> T deserialize(Payload<T> myPayload) {

        try {
            return getCommonSerializer().readValue(myPayload.json(), myPayload.type());
        } catch (JsonProcessingException e) {
            LOGGER.trace(e.getLocalizedMessage(), e);
            throw new RuntimeException(e);
        }
    }
}
