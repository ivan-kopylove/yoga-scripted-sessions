package com.github.lazyf1sh.logic.resource.reader.txt.spi;


import com.github.lazyf1sh.domain.SourceFile;

@FunctionalInterface
public interface ReadTxtResourceSpi {

    SourceFile readTxt(Payload myPayload);


    record Payload(Class<?> myPayload) {
    }

}
