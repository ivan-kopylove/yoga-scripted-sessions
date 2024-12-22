package com.github.lazyf1sh.domain;

import java.io.IOException;
import java.util.List;

public interface Suite {
    List<Class<?>> build() throws IOException;
}
