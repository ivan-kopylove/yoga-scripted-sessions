package com.github.lazyf1sh.logic;

import com.github.lazyf1sh.api.deeplx.DeepLXClient;
import com.github.lazyf1sh.domain.Line;
import com.github.lazyf1sh.domain.SourceFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.github.lazyf1sh.domain.LineType.REGULAR;

public class Translator
{
    private static final DeepLXClient deepLXClient = new DeepLXClient();
    private static final Logger       LOGGER       = LoggerFactory.getLogger(Translator.class);

    public void enrichWithTranslation(final List<SourceFile> content) throws IOException
    {
        boolean changes = false;
        for (final SourceFile sourceFile : content)
        {

            for (final Line line : sourceFile.getLines())
            {
                final int chance = ThreadLocalRandom.current()
                                                    .nextInt(0, 101);

                if (chance > 99 && line.getLineType() == REGULAR && line.en()
                                                                        .isEmpty())
                {
                    changes = true;
                    final String translated = deepLXClient.translate(line.ru());
                    line.put("en", translated);
                    LOGGER.info("{} {}",
                                line.ru(),
                                line.en()
                                    .orElseThrow());
                }
            }


            if (changes)
            {
                final StringBuilder builder = new StringBuilder();

                for (final Line line : sourceFile.getLines())
                {
                    builder.append(line.getJson())
                           .append("\n");
                }
                if (sourceFile.getPath() != null)
                {
                    try
                    {
                        Files.write(sourceFile.getPath(),
                                    builder.toString()
                                           .getBytes());
                    }
                    catch (final IOException e)
                    {
                        LOGGER.error("Error writing to file", e);
                        throw e;
                    }
                }
            }
            changes = false;
        }
    }
}
