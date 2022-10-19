package com.github.lazyf1sh.nodes;

import java.io.IOException;

import static com.github.lazyf1sh.util.ReadAsanaParams2.readAsanaParams2;
import static com.github.lazyf1sh.util.Util.readConventionalWay;
import static com.github.lazyf1sh.util.Util.readFile;

public abstract class Asana2 {
    public String build() throws IOException {
        return readConventionalWay(readAsanaParams2().resourceBundleClass(this.getClass()));
    }
}
