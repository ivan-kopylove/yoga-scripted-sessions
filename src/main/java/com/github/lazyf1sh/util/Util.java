package com.github.lazyf1sh.util;

import java.io.IOException;
import java.nio.file.Paths;

import static java.nio.file.Files.readAllBytes;

public class Util {

    @Deprecated
    public static String readFile(final String name) throws IOException {
        final byte[] bytes = readAllBytes(Paths.get("components/" + name));
        if (bytes == null && bytes.length < 2) {
            throw new RuntimeException("b5344e5d-fa05-40da-905d-24a1fb66074e");
        }

        return new String(bytes);
    }

    public static String readFile(final String name, final String lang) throws IOException {
        final byte[] bytes = readAllBytes(Paths.get("components/" + name + "-" + lang));
        if (bytes == null && bytes.length < 2) {
            throw new RuntimeException("error reading a file" + name);
        }

        return new String(bytes);
    }

}
