package com.github.lazyf1sh.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Util {
    public static String readFile(final String name) throws IOException {
        final byte[] bytes = Files.readAllBytes(Paths.get("components/" + name));
        if (bytes == null && bytes.length < 2) {
            throw new RuntimeException("b5344e5d-fa05-40da-905d-24a1fb66074e");
        }
        final String s = new String(bytes);

        return s;
    }

}
