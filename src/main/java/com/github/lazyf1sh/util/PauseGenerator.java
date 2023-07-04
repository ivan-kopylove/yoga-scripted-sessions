package com.github.lazyf1sh.util;

import java.io.IOException;
import java.nio.file.Path;
import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.SECONDS;

public class PauseGenerator {

    public void generate(int length, String filename, Path directory) throws InterruptedException, IOException, ExecutionException, TimeoutException {
        ProcessBuilder builder = new ProcessBuilder();
        int seconds = length / 1000;
        if(seconds < 1)
        {
            seconds = 1;
        }
        builder.command("ffmpeg", "-f", "lavfi", "-i", "anullsrc", "-t", String.valueOf(seconds), "-c:a", "libvorbis", filename);

        builder.directory(directory.toFile());
        Process process = builder.start();


        ExecutorService executorService = Executors.newSingleThreadExecutor();

            StreamGobbler streamGobbler =
                    new StreamGobbler(process.getInputStream(), System.out::println);
            Future<?> future = executorService.submit(streamGobbler);

            process.waitFor();

            future.get(10, SECONDS);

        //executorService.close();


    }
}
