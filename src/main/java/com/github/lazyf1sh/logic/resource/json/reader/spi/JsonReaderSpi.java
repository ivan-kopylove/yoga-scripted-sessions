package com.github.lazyf1sh.logic.resource.json.reader.spi;


@FunctionalInterface
public interface JsonReaderSpi {

    String readJsonAsanaResouce(Payload myPayload);


    record Payload(Class<?> myPayload) {
    }

}
