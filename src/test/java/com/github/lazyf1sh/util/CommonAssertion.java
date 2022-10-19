package com.github.lazyf1sh.util;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public final class CommonAssertion {

    public static void allCommonChecks(final String result, final Class<?> clazz) {
        containsNoCurlyBrackets(result);
        containsNoWords(result);
        containsNoResourceBundleKeys(result, clazz);
        containsNewLines(result);
    }

    public static void containsNoCurlyBrackets(final String result) {
        assertFalse(result.contains("{{"));
        assertFalse(result.contains("}}"));
    }

    public static void containsNewLines(final String result) {
        assertThat(result.startsWith("\n"), equalTo(true));
        assertThat(result.endsWith("\n"), equalTo(true));
    }

    public static void containsNoResourceBundleKeys(final String result, final Class<?> clazz) {
        try {
            final ResourceBundle bundle = ResourceBundle.getBundle(clazz.getName() + "Resource", Locale.forLanguageTag("ru"));
            bundle.keySet().forEach(key -> assertThat(result, not(containsString(key))));
        } catch (MissingResourceException e) {
            Logger.getAnonymousLogger().info(e.getLocalizedMessage());
        }
    }

    public static void containsNoWords(final String result) {
        assertFalse(result.contains(" старай"));
        assertFalse(result.contains(" нужно "));
        assertFalse(result.contains(" ваш"));
        assertFalse(result.contains(" надо "));
        assertFalse(result.contains(" придется "));
        assertFalse(result.contains(" придётся "));
    }

}
