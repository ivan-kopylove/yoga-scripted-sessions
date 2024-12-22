package com.github.lazyf1sh.logic.resource.files;


import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.logic.resource.files.extension.ResourceExtension;
import com.github.lazyf1sh.logic.resource.files.extension.spi.DetermineExtensionSpi;
import com.github.lazyf1sh.logic.resource.json.reader.spi.JsonReaderSpi;
import com.github.lazyf1sh.util.Util;

public class ReadResourceUseCase implements ReadResourceApi {

    private final DetermineExtensionSpi determineExtensionSpi;
    private final JsonReaderSpi jsonReaderSpi;

    public ReadResourceUseCase(DetermineExtensionSpi determineExtensionSpi, JsonReaderSpi jsonReaderSpi) {
        this.determineExtensionSpi = determineExtensionSpi;
        this.jsonReaderSpi = jsonReaderSpi;
    }

    @Override
    public SourceFile read(Class<?> clazz) {
        ResourceExtension extension = determineExtensionSpi.callMe(new DetermineExtensionSpi.Payload(clazz));
        switch (extension) {
            case JSON -> {
                jsonReaderSpi.readJsonAsanaResouce(new JsonReaderSpi.Payload(clazz));
            }
            case TXT -> {
                return Util.readConventionalWayTxt(clazz);
            }
        }
        return null;
    }
}
