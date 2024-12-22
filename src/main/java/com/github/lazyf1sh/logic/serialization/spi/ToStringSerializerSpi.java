package com.github.lazyf1sh.logic.serialization.spi;


@FunctionalInterface
public interface ToStringSerializerSpi {

    String serialize(Payload myPayload);


    record Payload(Object any) {
    }

}
