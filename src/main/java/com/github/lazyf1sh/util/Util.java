package com.github.lazyf1sh.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.lazyf1sh.domain.Line;
import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.file.Files.readAllBytes;
import static java.util.stream.Collectors.toList;

public final class Util {


    private final static ObjectMapper objectMapper = new ObjectMapper();

    @Deprecated
    public static String readFile(final String name) throws IOException {
        final byte[] bytes = readAllBytes(Paths.get("components/" + name));
        if (bytes.length < 2) {
            throw new RuntimeException("b5344e5d-fa05-40da-905d-24a1fb66074e");
        }

        String result = new String(bytes);
        result += "\n";
        result = "\n" + result;

        return result;
    }

    @Deprecated // use bundler reader where payload is placed near the class
    public static String readFile(final String name, final String lang) throws IOException {
        final byte[] bytes = readAllBytes(Paths.get("components/" + name + "-" + lang));
        if (bytes.length < 2) {
            throw new RuntimeException("error reading a file" + name);
        }

        String result = new String(bytes);
        result += "\n";
        result = "\n" + result;

        return result;
    }


    public static String readConventionalWay(final ReadAsanaParams params) throws IOException {
        String name = (params
                .getResourceBundleClass()
                .getName()
                .replace(".", "/"))
                + "_ru.txt";


        String path = params
                .getResourceBundleClass()
                .getClassLoader()
                .getResource(name)
                .getPath();

        path = path.replaceFirst("/", "");

        Path path1 = Paths.get(path);

        List<String> lines = Files.readAllLines(path1);
        List<Line> lines1 = lines.stream()
                .filter(line -> line.length() > 0)
                .map(line -> {
                    try {
                        return new Line(line);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e + " " + path1);
                    }
                }).collect(toList());

        new SourceFile(path1, lines1);


        final byte[] bytes = readAllBytes(path1);
        if (bytes.length < 2) {
            throw new RuntimeException("Error reading the file " + path);
        }
        String result = new String(bytes);
        result = "\n" + result + "\n";

        return result;
    }


    @Deprecated()
    public static String readFile(final Path path, final String lang) throws IOException {
        final byte[] bytes = readAllBytes(Paths.get("components/" + path + "-" + lang + ".txt"));
        if (bytes.length < 2) {
            throw new RuntimeException("Error reading the file" + path);
        }

        String result = new String(bytes);
        result += "\n";
        result = "\n" + result;

        return result;
    }
}
