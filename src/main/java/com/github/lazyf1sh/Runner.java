package com.github.lazyf1sh;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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

        String ardhaUttanasanaWithStandingPoint = readFile("ardha-uttanasana-with-standing-point.txt");
        String kapalabhati3Rounds = readFile("kapalabhati-3-rounds.txt");
        String bitilasana = readFile("bitilasana.txt");
        String marjariasanaWithKneeToElbow = readFile("marjariasana-with-knee-to-elbow.txt");
        String dandayamanaBharmanasanaBalancingTable = readFile("dandayamana-Bharmanasana-balancing-table.txt");
        String ekaHastaVjagrasanaCrossHook = readFile("eka-hasta-vjagrasana-cross-hook.txt");
        String ekaPadaAdhoMukhaSvanasanaWithElbowDown = readFile("eka-pada-adho-mukha-svanasana-with-elbow-down.txt");
        String transitionEf2eb0af2276 = readFile("transition-ef2eb0af2276.txt");
        String dolphin = readFile("dolphin.txt");
        String transitionB21ef52bd090 = readFile("transition-b21ef52bd090.txt");
        String springOfLegMovedToASide = readFile("spring-of-leg-moved-to-a-side.txt");
        String transition266ae7aacbff = readFile("transition-266ae7aacbff.txt");
        String rotateAKneeOutwards = readFile("rotate-a-knee-outwards.txt");
        String unknownD856222abcd5 = readFile("unknown-d856222abcd5.txt");
        String bigToeToAar = readFile("big-toe-to-ear.txt");
        String ekaHastaVjagrasanaOneSideHook = readFile("eka-hasta-vjagrasana-one-side-hook.txt");
        String suryaNamaskarSides = readFile("surya-namaskar-sides.txt");


        String commonOutro = getCommonOutro();

        StringBuilder finalString = new StringBuilder();
        finalString.append(commonIntro);
        finalString.append(part1);
        finalString.append(part2);
        finalString.append(part3);
        finalString.append(part4);
        finalString.append(ardhaUttanasanaWithStandingPoint);
        finalString.append(kapalabhati3Rounds);
        finalString.append(bitilasana);
        finalString.append(marjariasanaWithKneeToElbow);
        finalString.append(dandayamanaBharmanasanaBalancingTable);
        finalString.append(ekaHastaVjagrasanaCrossHook);
        finalString.append(ekaPadaAdhoMukhaSvanasanaWithElbowDown);
        finalString.append(transitionEf2eb0af2276);
        finalString.append(dolphin);
        finalString.append(transitionB21ef52bd090);
        finalString.append(springOfLegMovedToASide);
        finalString.append(transition266ae7aacbff);
        finalString.append(rotateAKneeOutwards);
        finalString.append(unknownD856222abcd5);
        finalString.append(bigToeToAar);
        finalString.append(ekaHastaVjagrasanaOneSideHook);
        finalString.append(suryaNamaskarSides);
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

//        content = buildSuryaSession();
//        content = buildHipsOpeningSession();
        content = buildBendsSession();


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
        int nextChunk = 4900;

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
