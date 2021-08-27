package com.github.lazyf1sh;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.github.lazyf1sh.asanas.SuryaSessionBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Runner
{


    /**
     * Use {@link Util#readFile(String)}.
     *
     * @param name
     * @return
     * @throws IOException
     */
    @Deprecated
    private static String readFile(String name) throws IOException
    {
        return Util.readFile(name);
    }




    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        YogaConfig yogaConfig = objectMapper.readValue(new File("src/main/resources/yoga.config.yml"), YogaConfig.class);

        SuryaSessionBuilder suryaSessionBuilder = new SuryaSessionBuilder(yogaConfig);
        HipsOpeningBuilder hipsOpeningBuilder = new HipsOpeningBuilder();
        BendsBuilder bendsBuilder = new BendsBuilder();
        AlpenvillaIntroBuilder alpenvillaIntroBuilder = new AlpenvillaIntroBuilder();

        String content;


//        content = alpenvillaIntroBuilder.buildAlpenVillaIntro();
        content = suryaSessionBuilder.buildSuryaSession();
//        content = hipsOpeningBuilder.buildHipsOpeningSession();
//        content = bendsBuilder.buildBendsSession();


        content = multipleTrim(content);

        ArrayList<String> piecesOfText = new ArrayList<>();
        splitIntoPieces(content, piecesOfText);

        for (int i = 0, piecesOfTextSize = piecesOfText.size(); i < piecesOfTextSize; i++) {
            String text = piecesOfText.get(i);
            byte[] generated = YandexSpeechSynthesisAPI.generate(text);
            saveSingle(String.format("%02d.ogg", i), generated);
        }
    }
    private static void saveSingle(String filename, byte[] content) throws IOException
    {
        Path directory = Files.createDirectories(Paths.get("output-ogg"));

        Path file = Paths.get(directory.toString(), filename);

        Files.write(file, content);
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
        int nextChunk = 4800;

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
