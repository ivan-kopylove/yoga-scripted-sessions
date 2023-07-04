package com.github.lazyf1sh.util;

import com.github.lazyf1sh.yandex.speech.api.Voice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import static com.github.lazyf1sh.util.SHA3.sha3_256;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.Files.exists;

public class Cache {

    public static final String CACHE = "cache";

    public Optional<byte[]> get(String text, Voice voice) throws NoSuchAlgorithmException, IOException, InterruptedException {
        String pieceName = sha3_256(text.getBytes());
        final Path ogg = Paths.get(CACHE, String.format("%s_%s.ogg", pieceName, voice));
        if (exists(ogg)) {

            System.out.println("took from cache: " + ogg);
            return Optional.of(Files.readAllBytes(ogg));
        } else {
            return Optional.empty();
        }
    }

    public void overwrite(String text, Voice voice, byte[] payload) throws NoSuchAlgorithmException, IOException {

        String pieceName = sha3_256(text.getBytes());
        final Path ogg = Paths.get(CACHE, String.format("%s_%s.ogg", pieceName, voice));
        final Path txt = Paths.get(CACHE, String.format("%s_%s.txt", pieceName, voice));

        System.out.println("overwriting " + ogg);
        Files.write(ogg, payload);
        Files.write(txt, text.getBytes(UTF_8));
    }

}