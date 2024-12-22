package com.github.lazyf1sh.logic.resource.files;

import com.github.lazyf1sh.domain.SourceFile;

@FunctionalInterface
public interface ReadResourceApi {
    SourceFile readResource(Class<?> clazz);
}
