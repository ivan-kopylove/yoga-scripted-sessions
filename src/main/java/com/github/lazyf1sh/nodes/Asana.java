package com.github.lazyf1sh.nodes;

import com.github.lazyf1sh.sides.Side;

import java.io.IOException;

import static com.github.lazyf1sh.sides.Side.LEFT_DEFAULT;
import static com.github.lazyf1sh.util.ReadAsanaParams2.readAsanaParams2;
import static com.github.lazyf1sh.util.Util.readConventionalWay;

public abstract class Asana {
    private Side side = LEFT_DEFAULT;

    public Asana(Side side) {
        this.side = side;
    }

    protected Asana() {

    }

    public String build() throws IOException {
        return readConventionalWay(readAsanaParams2().side(side).resourceBundleClass(this.getClass()));
    }
}
