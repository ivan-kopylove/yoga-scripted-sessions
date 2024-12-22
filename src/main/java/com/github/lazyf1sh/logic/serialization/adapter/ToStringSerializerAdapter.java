package com.github.lazyf1sh.logic.serialization.adapter;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.lazyf1sh.logic.serialization.spi.ToStringSerializerSpi;

import static com.github.ivan.kopylove.commons.serialization.CommonSerializationConfig.getCommonSerializer;

public class ToStringSerializerAdapter implements ToStringSerializerSpi {


    @Override
    public String serialize(Payload myPayload) {

        try {
            return getCommonSerializer().writeValueAsString(new Payload(myPayload.any()));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}
