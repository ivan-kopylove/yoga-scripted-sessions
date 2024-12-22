package com.github.lazyf1sh.logic.phrase.common.spi;


@FunctionalInterface
public interface CommonBeginningConfigurationSpi {

    String callMe(Payload myPayload);


    record Payload(String myPayload) {
    }

}
