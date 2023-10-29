package com.github.lazyf1sh.domain;

import java.io.IOException;
import java.util.List;

public interface Suite {
    List<SourceFile> build() throws IOException;
}
