package com.github.lazyf1sh.logic.serialization.spi;


import com.fasterxml.jackson.core.type.TypeReference;

@FunctionalInterface
public interface SerializeToObjectSpi {

    <T> T deserialize(Payload<T> myPayload);


    record Payload<T>(String json, TypeReference<T> type) {
    }

}
