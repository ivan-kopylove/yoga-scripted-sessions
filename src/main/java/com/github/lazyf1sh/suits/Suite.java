package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;
import java.util.List;

public interface Suite {

    List<SourceFile> build() throws IOException;
}
