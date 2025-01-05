package com.github.lazyf1sh.logic.resource.files;


import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.logic.resource.reader.json.spi.ReadJsonResourceSpi;

public class ReadResourceUseCase implements ReadResourceApi {

    private final ReadJsonResourceSpi readJsonResourceSpi;

    public ReadResourceUseCase(ReadJsonResourceSpi readJsonResourceSpi) {
        this.readJsonResourceSpi = readJsonResourceSpi;
    }

    @Override
    public SourceFile readResource(Class<?> clazz) {
        return readJsonResourceSpi.readJsonResource(new ReadJsonResourceSpi.Payload(clazz));
    }
}
