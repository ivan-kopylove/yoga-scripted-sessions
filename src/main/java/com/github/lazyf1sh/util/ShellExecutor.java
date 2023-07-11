package com.github.lazyf1sh.util;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ShellExecutor {

    private SessionParameters sessionParameters;

    public ShellExecutor(SessionParameters sessionParameters) {

        this.sessionParameters = sessionParameters;
    }

    public void exec(String command) throws InterruptedException, IOException, ExecutionException, TimeoutException {
        System.out.printf("Running %s\n", command);
        ProcessBuilder builder = new ProcessBuilder();

        builder.command(command.split(" "));
        builder.directory(sessionParameters.workingDir().toFile());
        Process process = builder.start();

        StreamGobbler regular = new StreamGobbler(process.getInputStream(), System.out::println, "regular");
        StreamGobbler err = new StreamGobbler(process.getErrorStream(), System.out::println, "errors");

        Future<?> errFuture = sessionParameters.getStreamGobblerPool().submit(err);
        Future<?> future = sessionParameters.getStreamGobblerPool().submit(regular);

        process.waitFor();

        future.get(10, SECONDS);
        errFuture.get(10, SECONDS);
    }
}
