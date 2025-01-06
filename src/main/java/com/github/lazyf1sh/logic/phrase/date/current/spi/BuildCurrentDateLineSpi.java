package com.github.lazyf1sh.logic.phrase.date.current.spi;


import com.github.lazyf1sh.domain.SourceFile;

@FunctionalInterface
public interface BuildCurrentDateLineSpi {

    SourceFile buildCurrentDate();



}
