package com.github.lazyf1sh.logic.resource.files.saver.usecase;

import com.github.lazyf1sh.logic.resource.files.saver.api.SaveFileApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SaveFileUseCase implements SaveFileApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(SaveFileUseCase.class);

    @Override
    public void saveFile(Payload myPayload) {
        try {
            Path file = Paths.get(myPayload.directory().toString(), myPayload.filename());
            Files.write(file, myPayload.content());
        } catch (IOException e) {
            LOGGER.warn(e.getLocalizedMessage(), e);
            throw new RuntimeException(e);
        }
    }

}