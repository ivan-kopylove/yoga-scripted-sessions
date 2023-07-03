package com.github.lazyf1sh.nodes.marjariasana;

import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.nodes.Asana;

import java.io.IOException;

public class MarjariasanaKneeToForehead extends Asana {

    private MarjariasanaKneeToForehead() {
    }

    public static SourceFile marjariasanaKneeToForehead() throws IOException {
        return new MarjariasanaKneeToForehead().build();
    }
}
