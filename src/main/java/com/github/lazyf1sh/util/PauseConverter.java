package com.github.lazyf1sh.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class PauseConverter {

    public String distributePause(String content) throws IOException {

        StringBuilder result = new StringBuilder("");
        BufferedReader bufReader = new BufferedReader(new StringReader(content));

        String line = null;
        while ((line = bufReader.readLine()) != null) {
            if (line.startsWith("sil<[")) {
                if (!line.startsWith("sil<[6000]>")) {
                    int duration = Integer.parseInt(line.split("\\[")[1].split("\\]")[0]);
                    int parts = (duration / 6000) + 1;

                    if (parts > 1) {
                        for (int i = 0; i < parts; i++) {
                            result.append(" sil<[6000]> ");
                        }
                    } else {
                        result.append(line);
                    }
                }
                else
                {
                    result.append(line);
                }
            } else {
                result.append(line);
            }
        }

        return result.toString();
    }
}
