package com.github.lazyf1sh.logic.resource.files.saver.api;

import java.nio.file.Path;

@FunctionalInterface
public interface SaveFileApi {
    void saveFile(Payload myPayload);

    record Payload(String filename, byte[] content, Path directory) {
    }


}
