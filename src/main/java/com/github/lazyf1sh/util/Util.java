package com.github.lazyf1sh.util;

import com.github.lazyf1sh.sides.Side;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.github.lazyf1sh.sides.TextReplacer.enrichSidePlaceHolder;
import static java.nio.file.Files.readAllBytes;

public final class Util {

    @Deprecated // use readAsana / readTransition
    public static String readFile(final String name) throws IOException {
        final byte[] bytes = readAllBytes(Paths.get("components/" + name));
        if (bytes == null && bytes.length < 2) {
            throw new RuntimeException("b5344e5d-fa05-40da-905d-24a1fb66074e");
        }

        return new String(bytes);
    }

    @Deprecated // use readAsana / readTransition
    public static String readFile(final String name, final String lang) throws IOException {
        final byte[] bytes = readAllBytes(Paths.get("components/" + name + "-" + lang));
        if (bytes == null && bytes.length < 2) {
            throw new RuntimeException("error reading a file" + name);
        }

        return new String(bytes);
    }

    public static String readAsana(final Path path, final String lang, Side side) throws IOException {
        return doRead(Paths.get("components/asanas/", path.toString()), lang, side);
    }

    private static String doRead(final Path path, final String lang, Side side) throws IOException {
        final byte[] bytes = readAllBytes(Paths.get(path.toString() + "-" + lang + ".txt"));
        if (bytes == null && bytes.length < 2) {
            throw new RuntimeException("Error reading the file" + path);
        }
        String result = new String(bytes);
        result = enrichSidePlaceHolder(side, result);
        result += "\n";

        return result;
    }

    @Deprecated() // use readAsana / readTransition
    public static String readFile(final Path path, final String lang) throws IOException {
        final byte[] bytes = readAllBytes(Paths.get("components/" + path + "-" + lang + ".txt"));
        if (bytes == null && bytes.length < 2) {
            throw new RuntimeException("Error reading the file" + path);
        }

        String result = new String(bytes);
        result += "\n";
        return result;
    }
}
