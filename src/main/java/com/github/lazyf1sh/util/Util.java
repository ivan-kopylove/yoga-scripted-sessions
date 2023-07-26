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
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import static com.github.lazyf1sh.domain.LineType.VOICE_SWITCH;
import static java.util.stream.Collectors.toList;

public final class Util
{

    private static final Logger LOGGER = LoggerFactory.getLogger(Util.class);

    private Util() {}

    public static SourceFile readConventionalWay(ReadAsanaParams params) throws IOException
    {
        String name = params.getResourceBundleClass()
                            .getSimpleName();

        URL resource = params.getResourceBundleClass()
                             .getResource(name + "_ru.txt");

        Objects.requireNonNull(resource);
        String path = resource.getPath();

        Path path1 = new File(path).toPath();

        List<Line> lines1 = getLines(path1);

        return new SourceFile(path1, lines1);
    }

    public static String convertToRu(SourceFile src) throws IOException
    {
        return convertToRu(List.of(src));
    }

    public static String convertToRu(List<SourceFile> src) throws IOException
    {
        StringBuilder builder = new StringBuilder();

        for (SourceFile sourceFile : src)
        {
            for (Line line : sourceFile.getLines())
            {

                if (line.getLineType() == VOICE_SWITCH)
                {
                    continue;
                }
                builder.append(line.ruOrPause()
                                   .orElseThrow())
                       .append("\n");
            }
        }

        return builder.toString();
    }

    public static <T> Comparator<T> shuffleComparator()
    {
        return Comparator.comparing(e -> ThreadLocalRandom.current()
                                                          .nextBoolean());
    }

    private static List<Line> getLines(Path path) throws IOException
    {
        List<String> lines = Files.readAllLines(path);
        List<Line> lines1 = lines.stream()
                                 .filter(line -> !line.isBlank())
                                 .map(line -> {
                                     try
                                     {
                                         return new Line(line);
                                     }
                                     catch (JsonProcessingException e)
                                     {
                                         LOGGER.error("JsonProcessingException {}", line, e);
                                         throw new RuntimeException(e + " " + path);
                                     }
                                 })
                                 .collect(toList());
        return lines1;
    }
}
