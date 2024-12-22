package com.github.lazyf1sh.logic.resource.files;


import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.logic.resource.files.extension.ResourceExtension;
import com.github.lazyf1sh.logic.resource.files.extension.spi.DetermineExtensionSpi;
import com.github.lazyf1sh.logic.resource.reader.json.spi.ReadJsonResourceSpi;
import com.github.lazyf1sh.logic.resource.reader.txt.spi.ReadTxtResourceSpi;

public class ReadResourceUseCase implements ReadResourceApi {

    private final DetermineExtensionSpi determineExtensionSpi;
    private final ReadJsonResourceSpi readJsonResourceSpi;
    private final ReadTxtResourceSpi readTxtResourceSpi;

    public ReadResourceUseCase(DetermineExtensionSpi determineExtensionSpi, ReadJsonResourceSpi readJsonResourceSpi, ReadTxtResourceSpi readTxtResourceSpi) {
        this.determineExtensionSpi = determineExtensionSpi;
        this.readJsonResourceSpi = readJsonResourceSpi;
        this.readTxtResourceSpi = readTxtResourceSpi;
    }

    @Override
    public SourceFile readResource(Class<?> clazz) {
        ResourceExtension extension = determineExtensionSpi.callMe(new DetermineExtensionSpi.Payload(clazz));
        switch (extension) {
            case JSON -> {
                return readJsonResourceSpi.readJsonResource(new ReadJsonResourceSpi.Payload(clazz));
            }
            case TXT -> {
                return readTxtResourceSpi.readTxtResouce(new ReadTxtResourceSpi.Payload(clazz));
            }
        }
        return null;
    }
}
