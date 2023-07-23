package com.github.lazyf1sh.util;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileResourcesUtils
{

    // print a file
    public static void printFile(File file)
    {

        List<String> lines;
        try
        {
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
            lines.forEach(System.out::println);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public List<File> getAllFilesFromResource(String folder, ClassLoader classLoader) throws URISyntaxException, IOException
    {


        URL resource = classLoader.getResource(folder);

        // dun walk the root path, we will walk all the classes
        List<File> collect = Files.walk(Paths.get(resource.toURI()))
                                  .filter(Files::isRegularFile)
                                  .map(x -> x.toFile())
                                  .collect(Collectors.toList());

        return collect;
    }
}
