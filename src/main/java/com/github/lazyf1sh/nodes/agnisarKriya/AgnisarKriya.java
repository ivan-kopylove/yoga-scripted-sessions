package com.github.lazyf1sh.nodes.agnisarKriya;

import com.github.lazyf1sh.suits.YogaSessionTextBuilder;

import java.io.IOException;
import java.nio.file.Paths;

public class AgnisarKriya extends YogaSessionTextBuilder {
    public AgnisarKriya() {
        super(Paths.get("asanas/agnisar-kriya/agnisar-kriya-payload"));
    }

    public static String agnisarKriya() throws IOException {
        return new AgnisarKriya().build();
    }
}
