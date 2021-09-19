package com.github.lazyf1sh.util;

import com.github.lazyf1sh.sides.Side;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.ResourceBundle;

import static com.github.lazyf1sh.sides.TextReplacer.enrichSidePlaceHolder;
import static java.nio.file.Files.readAllBytes;

public final class Util {

    @Deprecated // use readAsana / readTransition
    public static String readFile(final String name) throws IOException {
        final byte[] bytes = readAllBytes(Paths.get("components/" + name));
        if (bytes == null && bytes.length < 2) {
            throw new RuntimeException("b5344e5d-fa05-40da-905d-24a1fb66074e");
        }

        return new String(bytes);
    }

    @Deprecated // use readAsana / readTransition
    public static String readFile(final String name, final String lang) throws IOException {
        final byte[] bytes = readAllBytes(Paths.get("components/" + name + "-" + lang));
        if (bytes == null && bytes.length < 2) {
            throw new RuntimeException("error reading a file" + name);
        }

        return new String(bytes);
    }

    @Deprecated
    public static String readAsana(ReadAsanaParams params) throws IOException {
        return doRead(Paths.get("components/asanas/", params.path.toString()), params.lang, params.side, params.resourceBundleClass);
    }

    @Deprecated
    private static String doRead(final Path path, final String lang, final Side side, Class<?> resourceBundleClass) throws IOException {
        final byte[] bytes = readAllBytes(Paths.get(path.toString() + "-" + lang + ".txt"));
        if (bytes == null && bytes.length < 2) {
            throw new RuntimeException("Error reading the file" + path);
        }
        String result = new String(bytes);
        result = enrichSidePlaceHolder(side, result);
        result = fillResourceBundlePlaceholders(result, resourceBundleClass, lang);

        result += "\n";

        return result;
    }


    public static String doRead2(ReadAsanaParams params) throws IOException {

        String path = params.resourceBundleClass.getClassLoader().getResource(
                params.resourceBundleClass.getPackage().getName().replace('.', '/') + "/" + params.path.toString() + "_" + params.lang + ".txt"
        ).getPath();

        path = path.replaceFirst("/", "");


        final byte[] bytes = readAllBytes(Paths.get(path));
        if (bytes == null && bytes.length < 2) {
            throw new RuntimeException("Error reading the file" + params.path);
        }
        String result = new String(bytes);
        result = enrichSidePlaceHolder(params.side, result);
        result = fillResourceBundlePlaceholders(result, params.resourceBundleClass, params.lang);

        result += "\n";

        return result;
    }


    private static String fillResourceBundlePlaceholders(String text, Class<?> clazz, String lang) {
        final ResourceBundle bundle = ResourceBundle.getBundle(clazz.getName() + "Resource", Locale.forLanguageTag(lang));

        for (String key : bundle.keySet()) {
            String value = bundle.getString(key);
            if ("".equals(value)) {
                throw new RuntimeException("value should not be empty");
            }
            text = text.replace("{{" + key + "}}", value);
        }
        return text;
    }

    @Deprecated() // use readAsana / readTransition
    public static String readFile(final Path path, final String lang) throws IOException {
        final byte[] bytes = readAllBytes(Paths.get("components/" + path + "-" + lang + ".txt"));
        if (bytes == null && bytes.length < 2) {
            throw new RuntimeException("Error reading the file" + path);
        }

        String result = new String(bytes);
        result += "\n";
        return result;
    }

    public static class ReadAsanaParams {
        private Path path;
        private String lang;
        private Side side;
        private Class<?> resourceBundleClass;

        public static ReadAsanaParams readAsanaParams() {
            return new ReadAsanaParams();
        }

        public ReadAsanaParams path(final Path path) {
            this.path = path;
            return this;
        }

        public ReadAsanaParams lang(final String lang) {
            this.lang = lang;
            return this;
        }

        public ReadAsanaParams side(final Side side) {
            this.side = side;
            return this;
        }

        public ReadAsanaParams clazz(final Class<?> resourceBundleClass) {
            this.resourceBundleClass = resourceBundleClass;
            return this;
        }

        public Path getPath() {
            return path;
        }

        public String getLang() {
            return lang;
        }

        public Side getSide() {
            return side;
        }

        public Class<?> getResourceBundleClass() {
            return resourceBundleClass;
        }
    }

}
