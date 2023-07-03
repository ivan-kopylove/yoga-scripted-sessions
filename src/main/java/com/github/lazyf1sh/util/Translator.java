package com.github.lazyf1sh.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.concurrent.ThreadLocalRandom;

public class Translator {
    private static final String SIL = "sil<[";
    private static final DeepLXClient deepLXClient = new DeepLXClient();

    public String translate(String content) throws IOException {

        StringBuilder result = new StringBuilder();
        BufferedReader bufReader = new BufferedReader(new StringReader(content));

        String line;
        while ((line = bufReader.readLine()) != null) {
            int chance = ThreadLocalRandom.current().nextInt(0, 101);

            if (chance > 94 && !line.startsWith(SIL) && line.length() > 1) {
                String translated = deepLXClient.translate(line);
                result.append(translated).append("\n");
            } else {
                result.append(line).append("\n");
            }
        }

        return result.toString();
    }

}
