package com.github.lazyf1sh.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static java.util.function.Function.identity;

public class StreamGobbler implements Runnable {

    private final InputStream inputStream;
    private final String name;

    public StreamGobbler(InputStream inputStream, String name) {
        this.inputStream = inputStream;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                br.lines().forEach(identity()::apply);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
