package com.github.lazyf1sh.util;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertFalse;

public final class CommonAssertion
{

    private CommonAssertion() {}

    public static void allCommonChecks(String result, Class<?> clazz)
    {
        containsNoCurlyBrackets(result);
        containsNoWords(result);
        containsNoResourceBundleKeys(result, clazz);
    }

    public static void containsNoCurlyBrackets(String result)
    {
        assertFalse(result.contains("{{"));
        assertFalse(result.contains("}}"));
    }

    public static void containsNoResourceBundleKeys(String result, Class<?> clazz)
    {
        try
        {
            ResourceBundle bundle = ResourceBundle.getBundle(clazz.getName() + "Resource", Locale.forLanguageTag("ru"));
            bundle.keySet()
                  .forEach(key -> assertThat(result, not(containsString(key))));
        }
        catch (MissingResourceException e)
        {
            Logger.getAnonymousLogger()
                  .info(e.getLocalizedMessage());
        }
    }

    public static void containsNoWords(String result)
    {
        assertFalse(result.contains(" старай"));
        assertFalse(result.contains(" нужно "));
        assertFalse(result.contains(" ваш"));
        assertFalse(result.contains(" надо "));
        assertFalse(result.contains(" придется "));
        assertFalse(result.contains(" придётся "));
    }
}
