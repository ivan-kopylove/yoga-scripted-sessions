package com.github.lazyf1sh.nodes;

import java.io.IOException;

import static com.github.lazyf1sh.util.ReadAsanaParams2.readAsanaParams2;
import static com.github.lazyf1sh.util.Util.readConventionalWay;

public abstract class Asana {

    protected Asana() {

    }

    public String build() throws IOException {
        return readConventionalWay(readAsanaParams2().resourceBundleClass(this.getClass()));
    }
}
