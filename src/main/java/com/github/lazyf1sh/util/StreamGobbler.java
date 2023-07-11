package com.github.lazyf1sh.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class StreamGobbler implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(StreamGobbler.class);
    private final InputStream inputStream;
    private final Consumer<String> consumer;
    private final String name;

    public StreamGobbler(InputStream inputStream, Consumer<String> consumer, String name) {
        this.inputStream = inputStream;
        this.consumer = consumer;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                br.lines().forEach(consumer);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        LOGGER.info(name);
    }
}
