package com.github.lazyf1sh.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.lazyf1sh.domain.Line;
import com.github.lazyf1sh.domain.ReadAsanaParams;
import com.github.lazyf1sh.domain.SourceFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    public static SourceFile readConventionalWay(final ReadAsanaParams params) throws IOException
    {
        final String name = (params.getResourceBundleClass()
                                   .getName()
                                   .replace(".", "/")) + "_ru.txt";


        LOGGER.info("Loading resource {}", name);
        URL resource = params.getResourceBundleClass()
                             .getClassLoader()
                             .getResource(name);
        FileResourcesUtils app = new FileResourcesUtils();

        // read all files from a resources folder
        try
        {

            // files from src/main/resources/json
            List<File> result = app.getAllFilesFromResource("",
                                                            params.getResourceBundleClass()
                                                                  .getClassLoader());
            for (File file : result)
            {
                System.out.println("file --- : " + file);
            }
        }
        catch (URISyntaxException | IOException e)
        {
            e.printStackTrace();
        }

        Objects.requireNonNull(resource);
        String path = resource.getPath();

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

    public static <T> Comparator<T> shuffleComparator()
    {
        return Comparator.comparing(e -> ThreadLocalRandom.current()
                                                          .nextBoolean());
    }

    private static List<Line> getLines(final Path path) throws IOException
    {
        final List<String> lines = Files.readAllLines(path);
        final List<Line> lines1 = lines.stream()
                                       .filter(line -> !line.isBlank())
                                       .map(line -> {
                                           try
                                           {
                                               return new Line(line);
                                           }
                                           catch (final JsonProcessingException e)
                                           {
                                               LOGGER.error("JsonProcessingException {}", line, e);
                                               throw new RuntimeException(e + " " + path);
                                           }
                                       })
                                       .collect(toList());
        return lines1;
    }
}
