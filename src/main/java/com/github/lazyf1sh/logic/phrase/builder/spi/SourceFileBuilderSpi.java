package com.github.lazyf1sh.logic.phrase.builder.spi;


import com.github.lazyf1sh.domain.*;
import java.util.*;

@FunctionalInterface
public interface SourceFileBuilderSpi {

    List<SourceFile> getSourceFiles();


    record Payload(String myPayload) {
    }

}
