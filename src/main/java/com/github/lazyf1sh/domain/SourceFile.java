package com.github.lazyf1sh.domain;

import java.nio.file.Path;
import java.util.List;

public class SourceFile {

    private final Path path;
    private final List<Line> lines;

    public SourceFile(Path path, List<Line> lines) {
        this.path = path;
        this.lines = lines;
    }

    public Path getPath() {
        return path;
    }

    public List<Line> getLines() {
        return lines;
    }
}
