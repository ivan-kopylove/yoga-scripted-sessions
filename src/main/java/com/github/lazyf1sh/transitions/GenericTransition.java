package com.github.lazyf1sh.transitions;

import com.github.lazyf1sh.util.YogaConfig;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.github.lazyf1sh.util.Util.readFile;

public class GenericTransition {

    private final YogaConfig yogaConfig;
    private final Path filename;

    public GenericTransition(final YogaConfig yogaConfig, final Path filename) {
        this.yogaConfig = yogaConfig;
        this.filename = filename;
    }

    public static String genericTransition(final YogaConfig yogaConfig, final Path filename) throws IOException {
        return new GenericTransition(yogaConfig, filename).get();
    }

    public String get() throws IOException {
        return readFile(Paths.get("transitions/", filename.getFileName().toString()), yogaConfig.getLanguage());
    }
}
