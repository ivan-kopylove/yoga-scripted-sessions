package com.github.lazyf1sh;


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

    private static String buildHipsOpeningSession() throws IOException
    {
        StringBuilder result = new StringBuilder();
        result.append(AsanasBuilder.buildCommonIntro("ru"));
        result.append(AsanasBuilder.urdhvaHastasanaOnTiptoes());
        result.append(readFile("f2238bca3e1b.txt"));
        result.append(getHipsOpeningBody());
        result.append(AsanasBuilder.buildCommonOutro());
        return result.toString();
    }

    private static String getHipsOpeningBody() throws IOException
    {
        return readFile("hips-opening-body.txt");
    }

    private static String buildSuryaSession() throws IOException
    {
        StringBuilder result = new StringBuilder();
        result.append(AsanasBuilder.buildCommonIntro("ru"));
        result.append(AsanasBuilder.urdhvaHastasanaOnTiptoes());
        result.append(readFile("surya-namaskar-round-01.txt"));
        result.append(readFile("surya-namaskar-round-02.txt"));
        result.append(readFile("surya-namaskar-round-03.txt"));
        result.append(readFile("surya-namaskar-round-04.txt"));
        result.append(readFile("ardha-uttanasana-with-standing-point.txt"));
        result.append(readFile("kapalabhati-3-rounds.txt"));
        result.append(readFile("bitilasana.txt"));
        result.append(readFile("marjariasana-with-knee-to-elbow.txt"));
        result.append(readFile("dandayamana-Bharmanasana-balancing-table.txt"));
        result.append(readFile("eka-hasta-vjagrasana-cross-hook.txt"));
        result.append(readFile("eka-pada-adho-mukha-svanasana-with-elbow-down.txt"));
        result.append(readFile("transition-ef2eb0af2276.txt"));
        result.append(readFile("dolphin.txt"));
        result.append(readFile("transition-b21ef52bd090.txt"));
        result.append(readFile("spring-of-leg-moved-to-a-side.txt"));
        result.append(readFile("transition-266ae7aacbff.txt"));
        result.append(readFile("rotate-a-knee-outwards.txt"));
        result.append(readFile("unknown-d856222abcd5.txt"));
        result.append(readFile("big-toe-to-ear.txt"));
        result.append(readFile("eka-hasta-vjagrasana-one-side-hook.txt"));
        result.append(readFile("surya-namaskar-sides.txt"));
        result.append(AsanasBuilder.buildCommonOutro());
        return result.toString();
    }

    private static String buildBendsSession() throws IOException
    {
        StringBuilder result = new StringBuilder();
        result.append(AsanasBuilder.buildCommonIntro("ru"));
        result.append(AsanasBuilder.urdhvaHastasanaOnTiptoes());
        result.append(readFile("f2238bca3e1b.txt"));
        result.append(getBendsBody());
        result.append(AsanasBuilder.buildCommonOutro());
        return result.toString();
    }

    private static String getBendsBody() throws IOException
    {
        return readFile("bends-body.txt");
    }


    public static void main(String[] args) throws IOException
    {
        String content;

        content = buildSuryaSession();
//        content = buildHipsOpeningSession();
//        content = buildBendsSession();


        content = multipleTrim(content);

        ArrayList<String> piecesOfText = new ArrayList<>();
        splitIntoPieces(content, piecesOfText);

        for (int i = 0, piecesOfTextSize = piecesOfText.size(); i < piecesOfTextSize; i++)
        {
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
