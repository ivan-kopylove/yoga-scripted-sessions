package com.github.lazyf1sh.util;

import java.util.ArrayList;
import java.util.List;

public class TextSplitter {

    public static final int DEFAULT_CHUNK_SIZE = 4800;

    public List<String> split(final String content) {
        if (content.length() < 1) {
            throw new IllegalArgumentException("zero length content");
        }

        ArrayList<String> result = new ArrayList<>();

        if (content.length() < DEFAULT_CHUNK_SIZE) {
            result.add(content);
            return result;
        }


        String nextPortion = content;
        while (nextPortion.length() > DEFAULT_CHUNK_SIZE) {

            int nextChunkSize;

            nextChunkSize = calculateNextChunkSize(nextPortion);

            String currentPortion = nextPortion.substring(0, nextChunkSize);
            result.add(currentPortion);

            nextPortion = nextPortion.substring(nextChunkSize);
        }

        result.add(nextPortion);
        return result;
    }

    private int calculateNextChunkSize(final String nextPortion) {
        int nextChunkSize;

        String findDotInterval = nextPortion.substring(0, DEFAULT_CHUNK_SIZE);
        int pointLocation = findDotInterval.lastIndexOf(".");

        if (pointLocation < 0) {
            throw new IllegalArgumentException("not a business case, implement on demand");
        } else {
            nextChunkSize = pointLocation;
        }

        if (nextPortion.length() > nextChunkSize) {
            return nextChunkSize + 1;
        } else {
            return nextChunkSize;
        }


    }
}
