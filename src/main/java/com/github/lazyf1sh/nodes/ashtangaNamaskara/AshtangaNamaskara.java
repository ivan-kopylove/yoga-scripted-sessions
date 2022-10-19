package com.github.lazyf1sh.nodes.ashtangaNamaskara;

import com.github.lazyf1sh.nodes.Asana;
import com.github.lazyf1sh.microtype.FileName;
import com.github.lazyf1sh.nodes.Asana2;

import java.io.IOException;


public class AshtangaNamaskara extends Asana2 {

    private AshtangaNamaskara() {
        super();
    }

    public static String ashtangaNamaskara() throws IOException {
        return new AshtangaNamaskara().build();
    }
}
