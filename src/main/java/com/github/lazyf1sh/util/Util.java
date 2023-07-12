package com.github.lazyf1sh.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.lazyf1sh.domain.Line;
import com.github.lazyf1sh.domain.SourceFile;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.github.lazyf1sh.domain.LineType.VOICE_SWITCH;
import static java.util.stream.Collectors.toList;

public final class Util
{

    @Deprecated
    public static SourceFile readFile(final String name) throws IOException
    {
        final Path path = Paths.get("components/" + name);

        final List<Line> lines1 = getLines(path);

        return new SourceFile(path, lines1);
    }

    @Deprecated // use bundler reader where payload is placed near the class
    public static SourceFile readFile(final String name, final String lang) throws IOException
    {
        final Path path = Paths.get("components/" + name + "-" + lang);


        final List<Line> lines1 = getLines(path);

        return new SourceFile(path, lines1);
    }

    public static SourceFile readConventionalWay(final ReadAsanaParams params) throws IOException
    {
        final String name = (params.getResourceBundleClass()
                                   .getName()
                                   .replace(".", "/")) + "_ru.txt";


        String path = params.getResourceBundleClass()
                            .getClassLoader()
                            .getResource(name)
                            .getPath();

        path = path.replaceFirst("/", "");

        final Path path1 = Paths.get(path);

        final List<Line> lines1 = getLines(path1);

        return new SourceFile(path1, lines1);
    }

    public static String convertToRu(final SourceFile src) throws IOException
    {
        return convertToRu(List.of(src));
    }

    public static String convertToRu(final List<SourceFile> src) throws IOException
    {

        final StringBuilder builder = new StringBuilder();


        for (final SourceFile sourceFile : src)
        {
            for (final Line line : sourceFile.getLines())
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

    public static <T> Comparator<T> shuffle()
    {
        return Comparator.comparing(e -> ThreadLocalRandom.current()
                                                          .nextBoolean());
    }

    @NotNull
    private static List<Line> getLines(final Path path1) throws IOException
    {
        final List<String> lines = Files.readAllLines(path1);
        final List<Line> lines1 = lines.stream()
                                       .filter(line -> !line.equals(""))
                                       .map(line -> {
                                           try
                                           {
                                               return new Line(line);
                                           }
                                           catch (final JsonProcessingException e)
                                           {
                                               throw new RuntimeException(e + " " + path1);
                                           }
                                       })
                                       .collect(toList());
        return lines1;
    }

    @Deprecated()
    public static SourceFile readFile(final Path path, final String lang) throws IOException
    {
        final Path path1 = Paths.get("components/" + path + "-" + lang + ".txt");


        final List<Line> lines1 = getLines(path1);

        return new SourceFile(path1, lines1);
    }
}
