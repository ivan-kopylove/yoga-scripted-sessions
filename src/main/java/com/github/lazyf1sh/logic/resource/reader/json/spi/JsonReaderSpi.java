package com.github.lazyf1sh.logic.resource.reader.json.spi;


import com.github.lazyf1sh.domain.SourceFile;

@FunctionalInterface
public interface JsonReaderSpi {

    SourceFile readJsonAsanaResouce(Payload myPayload);


    record Payload(Class<?> myPayload) {
    }

}
