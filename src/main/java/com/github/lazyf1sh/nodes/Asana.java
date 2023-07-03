package com.github.lazyf1sh.nodes;

import java.io.IOException;

import static com.github.lazyf1sh.util.ReadAsanaParams.readAsanaParams;
import static com.github.lazyf1sh.util.Util.readConventionalWay;

public abstract class Asana {

    protected Asana() {

    }

    public String build() throws IOException {
        return readConventionalWay(readAsanaParams().resourceBundleClass(this.getClass()));
    }
}
