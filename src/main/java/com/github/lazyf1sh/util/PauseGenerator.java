package com.github.lazyf1sh.util;

import java.io.IOException;
import java.nio.file.Path;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

import static java.util.concurrent.TimeUnit.SECONDS;

public class PauseGenerator {

    private ApplicationWideParameters applicationWideParameters;

    public PauseGenerator(ApplicationWideParameters applicationWideParameters) {

        this.applicationWideParameters = applicationWideParameters;
    }

    public void generate(int length, String filename, Path directory) throws InterruptedException, IOException, ExecutionException, TimeoutException {
        ProcessBuilder builder = new ProcessBuilder();
        double seconds = (double) length / 1000;

        builder.command("ffmpeg", "-f", "lavfi", "-i", "anullsrc", "-t", String.valueOf(seconds), "-c:a", "libopus", filename);

        builder.directory(directory.toFile());
        Process process = builder.start();

        StreamGobbler regular = new StreamGobbler(process.getInputStream(), System.out::println, "pause");
        StreamGobbler err = new StreamGobbler(process.getErrorStream(), System.out::println, "pause");
        Future<?> future = applicationWideParameters.getStreamGobblerPool().submit(regular);
        Future<?> errFuture = applicationWideParameters.getStreamGobblerPool().submit(err);

        process.waitFor();

        future.get(30, SECONDS);
        errFuture.get(30, SECONDS);
    }
}
