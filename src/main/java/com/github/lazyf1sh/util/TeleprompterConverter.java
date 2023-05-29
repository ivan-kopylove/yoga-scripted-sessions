package com.github.lazyf1sh.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class TeleprompterConverter {


    private static final int MAX_CHARS_IN_LINE = 20;

    public String convert(String content) throws IOException {

        StringBuilder result = new StringBuilder("");
        BufferedReader bufReader = new BufferedReader(new StringReader(content));

        String line = null;
        while ((line = bufReader.readLine()) != null) {
            if (line.startsWith("sil<[")) {
                    int duration = Integer.parseInt(line.split("\\[")[1].split("\\]")[0]);
                    int linesToAdd = duration / 1000+2;

                    for(int i = linesToAdd; i > 0; i--)
                    {
                        result.append(i);
                        result.append("\n");
                    }
            } else {
                if(line.length() > MAX_CHARS_IN_LINE)
                {
                    String[] words = line.split(" ");
                    int currentChars = 0;
                    for (int i = 0; i < words.length - 1; i++) {

                        String word = words[i];
                        if (currentChars > MAX_CHARS_IN_LINE) {
                            result.append("\n");
                            result.append("\n");
                            result.append("\n");
                            result.append("\n");
                            result.append("\n");
                            currentChars = 0;
                        }

                        result.append(word).append(" ");

                        currentChars += word.length();
                    }


                    result.append(words[words.length-1]);

                }
                else
                {
                    result.append(line);
                }

                result.append("\n");
                result.append("\n");



            }
        }

        return result.toString();
    }
}
