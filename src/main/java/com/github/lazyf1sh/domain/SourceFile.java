package com.github.lazyf1sh.domain;

import java.nio.file.Path;
import java.util.List;

public class SourceFile {

    private Path path;
    private List<Line> lines;

    public SourceFile(Path path, List<Line> lines) {
        this.path = path;
        this.lines = lines;
    }
}
