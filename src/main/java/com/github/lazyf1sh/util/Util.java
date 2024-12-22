package com.github.lazyf1sh.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.lazyf1sh.domain.Line;
import com.github.lazyf1sh.domain.ReadAsanaParams;
import com.github.lazyf1sh.domain.SourceFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public final class Util {

    private static final Logger LOGGER = LoggerFactory.getLogger(Util.class);
    public static final String TXT_EXTENSION = ".txt";

    private Util() {
    }


    public static SourceFile readConventionalWayTxt(Class<?> clazz)  {
        try {
            String name = clazz.getSimpleName();

            URL resource = clazz.getResource(name + TXT_EXTENSION);

            Objects.requireNonNull(resource);
            String path = resource.getPath();

            Path path1 = new File(path).toPath();

            List<Line> lines1 = getLines(path1);

            return new SourceFile(name, lines1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static List<Line> getLines(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path);
        List<Line> lines1 = lines.stream()
                .filter(line -> !line.isBlank())
                .map(line -> {
                    try {
                        return new Line(line);
                    } catch (Exception e) {
                        LOGGER.error("JsonProcessingException {}", line, e);
                        throw new RuntimeException(e + " " + path);
                    }
                })
                .collect(toList());
        return lines1;
    }
}
