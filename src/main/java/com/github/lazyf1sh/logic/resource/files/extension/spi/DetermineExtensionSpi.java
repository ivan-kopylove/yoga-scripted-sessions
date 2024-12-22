package com.github.lazyf1sh.logic.resource.files.extension.spi;


import com.github.lazyf1sh.logic.resource.files.extension.ResourceExtension;

@FunctionalInterface
public interface DetermineExtensionSpi {

    ResourceExtension callMe(Payload myPayload);

    record Payload(Class<?> myPayload) {
    }

}
