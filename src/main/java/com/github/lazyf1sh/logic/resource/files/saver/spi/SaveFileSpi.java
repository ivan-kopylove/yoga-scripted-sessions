package com.github.lazyf1sh.logic.resource.files.saver.spi;


import java.nio.file.Path;

@FunctionalInterface
public interface SaveFileSpi {

    void saveFile(Payload myPayload);


    record Payload(String filename, byte[] content, Path directory) {
    }

}
