package com.github.lazyf1sh.logic;

import com.github.ivan.kopylove.commons.client.yandex.api.speech.Voice;
import com.github.lazyf1sh.domain.SessionParameters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;


import static com.github.ivan.kopylove.commons.util.SHA3.sha3_256;
import static java.nio.file.Files.exists;

public class Cache {
    public static final String CACHE = "cache";
    private static final Logger LOGGER = LoggerFactory.getLogger(Cache.class);
    private final SessionParameters sessionParameters;

    public Cache(SessionParameters sessionParameters) {
        this.sessionParameters = sessionParameters;
    }

    public Optional<byte[]> get(String text, Voice voice) {
        try {
            String pieceName = sha3_256(text.getBytes());
            Path ogg = Paths.get(CACHE, String.format("%s_%s.ogg", pieceName, voice));
            if (exists(ogg)) {
                LOGGER.info("reading from cache: " + ogg);
                sessionParameters.cacheHitsIncrement();
                return Optional.of(Files.readAllBytes(ogg));
            } else {
                return Optional.empty();
            }
        } catch (NoSuchAlgorithmException | IOException e) {
            LOGGER.warn(e.getLocalizedMessage(), e);
            throw new RuntimeException(e);
        }
    }

    public void overwrite(String text, Voice voice, byte[] payload) {

        try {
            String pieceName = sha3_256(text.getBytes());
            Path ogg = Paths.get(CACHE, String.format("%s_%s.ogg", pieceName, voice));
            LOGGER.info("overwriting " + ogg);
            Files.write(ogg, payload);
            sessionParameters.incrementCacheOverwrites();
        } catch (NoSuchAlgorithmException | IOException e) {
            LOGGER.warn(e.getLocalizedMessage(), e);
            throw new RuntimeException(e);
        }
    }
}