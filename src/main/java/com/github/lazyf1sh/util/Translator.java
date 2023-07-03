package com.github.lazyf1sh.util;

import com.github.lazyf1sh.domain.Line;
import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.github.lazyf1sh.domain.LineType.REGULAR;

public class Translator {
    private static final String SIL = "sil<[";
    private static final DeepLXClient deepLXClient = new DeepLXClient();

    public void enrichWitTranslation(List<SourceFile> content) throws IOException {
        for (SourceFile sourceFile : content) {
            for (Line line : sourceFile.getLines()) {
                int chance = ThreadLocalRandom.current().nextInt(0, 101);

                if (chance > 99 && line.getLineType() == REGULAR && !line.en().isPresent()) {
                    String translated = deepLXClient.translate(line.ru());
                    line.put("en", translated);
                   System.out.println(line.ru() + " " + line.en().orElseThrow());
                }
            }


            StringBuilder builder = new StringBuilder();

            for (Line line : sourceFile.getLines()) {
                builder.append(line.getJson()).append("\n");
            }
            if(sourceFile.getPath() != null)
            {
                Files.write(sourceFile.getPath(), builder.toString().getBytes());
            }
        }

    }
}
