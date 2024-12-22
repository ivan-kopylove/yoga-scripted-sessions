package com.github.lazyf1sh.logic.phrase.common.spi;


import com.github.lazyf1sh.domain.SourceFile;

import java.util.List;

@FunctionalInterface
public interface CommonBeginningConfigurationExecutorSpi {

    List<SourceFile> build();


}
