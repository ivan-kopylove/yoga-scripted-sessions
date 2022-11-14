package com.github.lazyf1sh.util;


import com.github.lazyf1sh.sides.Side;

import static com.github.lazyf1sh.sides.Side.LEFT_DEFAULT;

public class ReadAsanaParams2 {
    private Class<?> resourceBundleClass;
    private Side side = LEFT_DEFAULT;


    public static ReadAsanaParams2 readAsanaParams2() {
        return new ReadAsanaParams2();
    }

    public ReadAsanaParams2 resourceBundleClass(final Class<?> resourceBundleClass) {
        this.resourceBundleClass = resourceBundleClass;
        return this;
    }

    public ReadAsanaParams2 side(Side side) {
        this.side = side;
        return this;
    }

    public Side getSide() {
        return side;
    }

    public Class<?> getResourceBundleClass() {
        return resourceBundleClass;
    }
}