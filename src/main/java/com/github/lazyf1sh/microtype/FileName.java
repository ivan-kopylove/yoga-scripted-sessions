package com.github.lazyf1sh.microtype;

public class FileName {

    private final String value;

    public FileName(final String value) {
        this.value = value;
    }

    public static FileName fileName(final String fileName) {
        return new FileName(fileName);
    }

    public String getValue() {
        return value;
    }
}
