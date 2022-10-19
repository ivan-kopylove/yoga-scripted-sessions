package com.github.lazyf1sh.util;

import com.github.lazyf1sh.sides.Side;

import java.nio.file.Path;


public class ReadAsanaParams2 {
    private Class<?> resourceBundleClass;

    public static ReadAsanaParams2 readAsanaParams2() {
        return new ReadAsanaParams2();
    }

    public ReadAsanaParams2 resourceBundleClass(final Class<?> resourceBundleClass) {
        this.resourceBundleClass = resourceBundleClass;
        return this;
    }
    public Class<?> getResourceBundleClass() {
        return resourceBundleClass;
    }
}