package com.github.lazyf1sh;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Runner
{
    private static String readFile(String name) throws IOException
    {
        byte[] bytes = Files.readAllBytes(Paths.get("components/" + name));
        return new String(bytes);
    }

    private static String getCommonIntro() throws IOException
    {
        return readFile("common-intro.txt");
    }

    private static String getCommonOutro() throws IOException
    {
        return readFile("common-outro.txt");
    }

    private static String buildHipsOpeningSession() throws IOException
    {
        String commonIntro = getCommonIntro();
        String hipsOpeningBody = getHipsOpeningBody();
        String commonOutro = getCommonOutro();

        StringBuilder finalString = new StringBuilder();
        finalString.append(commonIntro);
        finalString.append(hipsOpeningBody);
        finalString.append(commonOutro);
        return finalString.toString();
    }

    private static String getHipsOpeningBody() throws IOException
    {
        return readFile("hips-opening-body.txt");
    }

    private static String buildSuryaSession() throws IOException
    {
        String commonIntro = getCommonIntro();
        String part1 = readFile("surya-namaskar-round-01.txt");
        String part2 = readFile("surya-namaskar-round-02.txt");
        String part3 = readFile("surya-namaskar-round-03.txt");
        String part4 = readFile("surya-namaskar-round-04.txt");
        String part5 = readFile("surya-namaskar-sides.txt");

        String commonOutro = getCommonOutro();

        StringBuilder finalString = new StringBuilder();
        finalString.append(commonIntro);
        finalString.append(part1);
        finalString.append(part2);
        finalString.append(part3);
        finalString.append(part4);
        finalString.append(part5);
        finalString.append(commonOutro);
        return finalString.toString();
    }

    private static String buildBendsSession() throws IOException
    {
        String commonIntro = getCommonIntro();
        String bendsBody = getBendsBody();
        String commonOutro = getCommonOutro();

        StringBuilder finalString = new StringBuilder();
        finalString.append(commonIntro);
        finalString.append(bendsBody);
        finalString.append(commonOutro);
        return finalString.toString();
    }

    private static String getBendsBody() throws IOException
    {
        return readFile("bends-body.txt");
    }


    public static void main(String[] args) throws IOException
    {
        String content;
        ArrayList<String> result = new ArrayList<>();
        content = buildSuryaSession();
//        content = buildHipsOpeningSession();
//        content = buildBendsSession();


        content = multipleTrim(content);
        splitIntoPieces(content, result);

        for (int i = 0; i < result.size(); i++)
        {
            saveSingle(i + ".txt", result.get(i));
        }

    }

    private static void saveSingle(String filename, String content) throws IOException
    {
        List<String> lines = Collections.singletonList(content);
        Path file = Paths.get("output/" + filename);
        Files.write(file, lines, StandardCharsets.UTF_8);
    }

    private static String multipleTrim(String content)
    {
        content = content.replace("\r\n", " ");
        content = content.replace("\n", " ");
        content = content.replace("\r", " ");
        for (int i = 0; i < 10; i++)
        {
            content = content.replace("  ", " ");
        }
        return content;
    }


    public static void splitIntoPieces(String content, List<String> result)
    {
        if (content.length() < 1)
        {
            return;
        }
        int nextChunk = ThreadLocalRandom.current().nextInt(1700, 1800);

        if (content.length() < nextChunk)
        {
            result.add(content);
            return;
        }

        if (nextChunk > content.length())
        {
            nextChunk = content.length();
        }

        int fromPoint = content.indexOf(".", nextChunk + 1) + 1;
        if (fromPoint < 0)
        {
            fromPoint = nextChunk;
        }
        if (fromPoint > content.length())
        {
            fromPoint = nextChunk;
        }

        String whole = content.substring(fromPoint);
        String chunk = content.substring(0, fromPoint);
        result.add(chunk);

        splitIntoPieces(whole, result);
    }
}
