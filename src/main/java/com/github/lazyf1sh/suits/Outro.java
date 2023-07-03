package com.github.lazyf1sh.suits;

import java.io.IOException;

import static com.github.lazyf1sh.util.ReadAsanaParams.readAsanaParams;
import static com.github.lazyf1sh.util.Util.readConventionalWay;

public class Outro {

    public String build() throws IOException {
        return readConventionalWay(readAsanaParams().resourceBundleClass(this.getClass()));
    }
}
