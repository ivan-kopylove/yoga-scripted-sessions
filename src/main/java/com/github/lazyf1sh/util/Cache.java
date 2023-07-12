package com.github.lazyf1sh.util;

import com.github.lazyf1sh.domain.Voice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import static com.github.lazyf1sh.util.SHA3.sha3_256;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.Files.exists;

public class Cache
{

    public static final  String            CACHE  = "cache";
    private static final Logger            LOGGER = LoggerFactory.getLogger(Cache.class);
    private final        SessionParameters sessionParameters;

    public Cache(final SessionParameters sessionParameters)
    {
        this.sessionParameters = sessionParameters;
    }

    public Optional<byte[]> get(final String text, final Voice voice) throws NoSuchAlgorithmException, IOException, InterruptedException
    {
        final String pieceName = sha3_256(text.getBytes());
        final Path ogg = Paths.get(CACHE, String.format("%s_%s.ogg", pieceName, voice));
        if (exists(ogg))
        {
            LOGGER.info("took from cache: " + ogg);
            sessionParameters.cacheHitsIncrement();
            return Optional.of(Files.readAllBytes(ogg));
        }
        else
        {
            return Optional.empty();
        }
    }

    public void overwrite(final String text, final Voice voice, final byte[] payload) throws NoSuchAlgorithmException, IOException
    {

        final String pieceName = sha3_256(text.getBytes());
        final Path ogg = Paths.get(CACHE, String.format("%s_%s.ogg", pieceName, voice));
        final Path txt = Paths.get(CACHE, String.format("%s_%s.txt", pieceName, voice));

        LOGGER.info("overwriting " + ogg);
        Files.write(ogg, payload);
        Files.write(txt, text.getBytes(UTF_8));
    }
}