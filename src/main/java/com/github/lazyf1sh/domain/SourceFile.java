package com.github.lazyf1sh.domain;

import java.util.List;

public class SourceFile {

    private final List<Line> lines;

    public SourceFile(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return lines;
    }
}
