package com.github.lazyf1sh.domain;

import java.util.List;

public class SourceFile {

    private final String name;
    private final List<Line> lines;

    public SourceFile(String name, List<Line> lines) {
        this.name = name;
        this.lines = lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    public String getName() {
        return name;
    }
}
