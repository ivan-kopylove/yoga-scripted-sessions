package com.github.lazyf1sh.util;

import static org.junit.Assert.assertFalse;

public class CommonAssertion {
    public static void containsNoCurlyBrackets(final String result) {
        assertFalse(result.contains("{{"));
        assertFalse(result.contains("}}"));
    }

    public static void containsNoWords(final String result) {
        assertFalse(result.contains("старай"));
        assertFalse(result.contains("нужно"));
        assertFalse(result.contains("надо"));
    }

}
