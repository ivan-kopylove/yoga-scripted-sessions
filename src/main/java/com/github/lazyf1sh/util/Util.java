package com.github.lazyf1sh.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.lazyf1sh.domain.Line;
import com.github.lazyf1sh.domain.SourceFile;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.util.stream.Collectors.toList;

public final class Util {


    private final static ObjectMapper objectMapper = new ObjectMapper();

    @Deprecated
    public static SourceFile readFile(final String name) throws IOException {
        Path path = Paths.get("components/" + name);

        List<Line> lines1 = getLines(path);

        return new SourceFile(path, lines1);
    }

    @Deprecated // use bundler reader where payload is placed near the class
    public static SourceFile readFile(final String name, final String lang) throws IOException {
        Path path = Paths.get("components/" + name + "-" + lang);


        List<Line> lines1 = getLines(path);

        return new SourceFile(path, lines1);
    }


    public static SourceFile readConventionalWay(final ReadAsanaParams params) throws IOException {
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

        List<Line> lines1 = getLines(path1);

        return new SourceFile(path1, lines1);
    }

    @NotNull
    private static List<Line> getLines(Path path1) throws IOException {
        List<String> lines = Files.readAllLines(path1);
        List<Line> lines1 = lines.stream()
                .filter(line -> !line.equals(""))
                .map(line -> {
                    try {
                        return new Line(line);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e + " " + path1);
                    }
                }).collect(toList());
        return lines1;
    }


    @Deprecated()
    public static SourceFile readFile(final Path path, final String lang) throws IOException {
        Path path1 = Paths.get("components/" + path + "-" + lang + ".txt");


        List<Line> lines1 = getLines(path1);

        return new SourceFile(path1, lines1);
    }
}
