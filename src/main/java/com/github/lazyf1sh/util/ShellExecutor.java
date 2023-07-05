package com.github.lazyf1sh.util;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

import static java.util.concurrent.Executors.newSingleThreadExecutor;
import static java.util.concurrent.TimeUnit.SECONDS;

public class ShellExecutor {

    private ApplicationWideParameters applicationWideParameters;

    public ShellExecutor(ApplicationWideParameters applicationWideParameters) {

        this.applicationWideParameters = applicationWideParameters;
    }

    public void exec(String command) throws InterruptedException, IOException, ExecutionException, TimeoutException {
        ProcessBuilder builder = new ProcessBuilder();

        builder.command(command.split(" "));
        builder.directory(applicationWideParameters.workingDir().toFile());
        Process process = builder.start();

        ExecutorService executorService = newSingleThreadExecutor();
        StreamGobbler streamGobbler = new StreamGobbler(process.getInputStream(), System.out::println);
        Future<?> future = executorService.submit(streamGobbler);

        process.waitFor();

        future.get(10, SECONDS);


        executorService.shutdown();
    }
}
