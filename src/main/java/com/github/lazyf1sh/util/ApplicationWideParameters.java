package com.github.lazyf1sh.util;

import java.nio.file.Path;

public class ApplicationWideParameters {

    private Path workingDir;

    public ApplicationWideParameters workingDir(Path workingDir) {
        this.workingDir = workingDir;
        return this;
    }

    public Path workingDir() {
        return this.workingDir;
    }

}
