package com.github.lazyf1sh.util;

import com.github.ivan.kopylove.commons.StreamGobbler;
import com.github.lazyf1sh.domain.SessionParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ShellExecutor {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShellExecutor.class);

    private final SessionParameters sessionParameters;

    public ShellExecutor(SessionParameters sessionParameters) {
        this.sessionParameters = sessionParameters;
    }

    public void exec(String command) throws InterruptedException, IOException, ExecutionException, TimeoutException {
        LOGGER.trace("Running {}", command);
        ProcessBuilder builder = new ProcessBuilder();

        builder.command(command.split(" "));
        builder.directory(sessionParameters.workingDir().toFile());
        Process process = builder.start();

        StreamGobbler regular = new StreamGobbler(process.getInputStream(), "regular");
        StreamGobbler err = new StreamGobbler(process.getErrorStream(), "error");

        Future<?> errFuture = sessionParameters.getStreamGobblerPool().submit(err);
        Future<?> future = sessionParameters.getStreamGobblerPool().submit(regular);

        process.waitFor();

        future.get(10, SECONDS);
        errFuture.get(10, SECONDS);
    }
}
