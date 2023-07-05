package com.github.lazyf1sh.util;

import java.io.*;
import java.util.function.Consumer;

public class StreamGobbler implements Runnable {
    private final InputStream inputStream;
    private final Consumer<String> consumer;
    private String name;

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

        System.out.println(name);
    }
}
