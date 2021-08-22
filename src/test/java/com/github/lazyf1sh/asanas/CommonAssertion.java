package com.github.lazyf1sh.asanas;

import static org.junit.Assert.assertFalse;

public class CommonAssertion {
    public static void containsNoCurlyBrackets(String result) {
        assertFalse(result.contains("{{"));
        assertFalse(result.contains("}}"));
    }

}
