package com.github.lazyf1sh.logic.resource.json.reader.spi;


import com.github.lazyf1sh.domain.SourceFile;

@FunctionalInterface
public interface JsonReaderSpi {

    SourceFile readJsonAsanaResouce(Payload myPayload);


    record Payload(Class<?> myPayload) {
    }

}
