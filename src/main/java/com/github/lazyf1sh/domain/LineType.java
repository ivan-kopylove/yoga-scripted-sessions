package com.github.lazyf1sh.domain;

public enum LineType
{
    REGULAR,
    SILENCE;

    public boolean isRegularLine(){
        return this == REGULAR;
    }
}
