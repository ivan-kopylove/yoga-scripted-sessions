package com.github.lazyf1sh.nodes.ashtangaNamaskara;

import com.github.lazyf1sh.nodes.Asana;

import java.io.IOException;


public class AshtangaNamaskara extends Asana {

    private AshtangaNamaskara() {
        super();
    }

    public static String ashtangaNamaskara() throws IOException {
        return new AshtangaNamaskara().build();
    }
}