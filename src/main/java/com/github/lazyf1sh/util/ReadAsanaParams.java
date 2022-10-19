package com.github.lazyf1sh.util;

import com.github.lazyf1sh.sides.Side;

import java.nio.file.Path;

@Deprecated //use ReadAsanaParams2
public class ReadAsanaParams {
    private Path path;
    private String lang;
    private Side side;
    private Class<?> resourceBundleClass;

    public static ReadAsanaParams readAsanaParams() {
        return new ReadAsanaParams();
    }

    public ReadAsanaParams path(final Path path) {
        this.path = path;
        return this;
    }

    public ReadAsanaParams lang(final String lang) {
        this.lang = lang;
        return this;
    }

    public ReadAsanaParams side(final Side side) {
        this.side = side;
        return this;
    }

    public ReadAsanaParams clazz(final Class<?> resourceBundleClass) {
        this.resourceBundleClass = resourceBundleClass;
        return this;
    }

    public Path getPath() {
        return path;
    }


    public Side getSide() {
        return side;
    }

    public Class<?> getResourceBundleClass() {
        return resourceBundleClass;
    }
}