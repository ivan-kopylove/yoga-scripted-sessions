package com.github.lazyf1sh.logic.resource.json.reader.spi;


import com.github.lazyf1sh.domain.SourceFile;

import java.util.List;

@FunctionalInterface
public interface JsonReaderSpi {

    SourceFile readJsonAsanaResouce(Payload myPayload);


    record Payload(Class<?> myPayload) {
    }

}
