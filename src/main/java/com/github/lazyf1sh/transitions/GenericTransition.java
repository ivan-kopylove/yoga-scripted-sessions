package com.github.lazyf1sh.transitions;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.github.lazyf1sh.util.Util.readFile;

public class GenericTransition {


    private final Path filename;

    public GenericTransition(final Path filename) {

        this.filename = filename;
    }

    public static String genericTransition(final Path filename) throws IOException {
        return new GenericTransition(filename).get();
    }

    public String get() throws IOException {
        return readFile(Paths.get("transitions/", filename.getFileName().toString()), "ru");
    }
}
