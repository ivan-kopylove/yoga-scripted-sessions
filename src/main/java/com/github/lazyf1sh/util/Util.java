package com.github.lazyf1sh.util;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import static com.github.lazyf1sh.sides.TextReplacer.enrichSidePlaceHolder;
import static java.nio.file.Files.readAllBytes;
import static java.util.ResourceBundle.getBundle;

public final class Util {

    @Deprecated  // use bundler reader where payload is placed near the class
    public static String readFile(final String name) throws IOException {
        final byte[] bytes = readAllBytes(Paths.get("components/" + name));
        if (bytes == null && bytes.length < 2) {
            throw new RuntimeException("b5344e5d-fa05-40da-905d-24a1fb66074e");
        }

        return new String(bytes);
    }

    @Deprecated // use bundler reader where payload is placed near the class
    public static String readFile(final String name, final String lang) throws IOException {
        final byte[] bytes = readAllBytes(Paths.get("components/" + name + "-" + lang));
        if (bytes == null && bytes.length < 2) {
            throw new RuntimeException("error reading a file" + name);
        }

        return new String(bytes);
    }


    public static String readConventionalWay(final ReadAsanaParams2 params) throws IOException {
        String name = (params
                .getResourceBundleClass()
                .getName()
                .replace(".", "/"))
                + "_ru.txt";


        String path = params
                .getResourceBundleClass()
                .getClassLoader()
                .getResource(name)
                .getPath();

        path = path.replaceFirst("/", "");

        final byte[] bytes = readAllBytes(Paths.get(path));
        if (bytes == null && bytes.length < 2) {
            throw new RuntimeException("Error reading the file " + path);
        }
        String result = new String(bytes);
        result = enrichSidePlaceHolder(params.getSide(), result);
        result = fillPlaceholdersBasedOnResourceBundle(result, params.getResourceBundleClass(), "ru");

        result += "\n";
        result = "\n" + result;

        return result;
    }


    private static String fillPlaceholdersBasedOnResourceBundle(String text, final Class<?> clazz, final String lang) {
        try {
            final ResourceBundle bundle = getBundle(clazz.getName() + "Resource", Locale.forLanguageTag(lang));

            for (final String key : bundle.keySet()) {
                final String value = bundle.getString(key);
                if ("".equals(value)) {
                    throw new RuntimeException("value should not be empty");
                }
                text = text.replace("{{" + key + "}}", value);
            }
        } catch (Exception e) {
            Logger.getAnonymousLogger().info(e.getMessage());
        }

        return text;
    }

    @Deprecated()  // use bundler reader where payload is placed near the class
    public static String readFile(final Path path, final String lang) throws IOException {
        final byte[] bytes = readAllBytes(Paths.get("components/" + path + "-" + lang + ".txt"));
        if (bytes == null && bytes.length < 2) {
            throw new RuntimeException("Error reading the file" + path);
        }

        String result = new String(bytes);

        result += "\n";
        result = "\n" + result;
        return result;
    }
}
