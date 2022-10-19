package com.github.lazyf1sh.sides;

import java.util.stream.Stream;

public class WordBuilder {

    public static final String LEFT_ROOT = "лев";
    public static final String RIGHT_ROOT = "прав";

    boolean ablativeCase;
    boolean accusativeCase;
    boolean feminineGender;
    boolean masculineGender;
    boolean neuterGender;
    private String root;

    private WordBuilder() {
    }

    public static WordBuilder wordBuilder() {
        return new WordBuilder();
    }

    public WordBuilder root(final String root) {
        this.root = root;
        return this;
    }

    public WordBuilder accusative() {
        this.accusativeCase = true;
        return this;
    }

    public WordBuilder ablative() {
        this.ablativeCase = true;
        return this;
    }

    public WordBuilder feminine() {
        this.feminineGender = true;
        return this;
    }

    public WordBuilder masculine() {
        this.masculineGender = true;
        return this;
    }

    public WordBuilder neuter() {
        this.neuterGender = true;
        return this;
    }


    public String build() {
        if (root == null || "".equals(root)) {
            throw new RuntimeException("root is required");
        }
        if (Stream.of(neuterGender, feminineGender, masculineGender).filter(Boolean::booleanValue).count() > 1) {
            throw new RuntimeException("only one gender is accepted.");
        }

        if (Stream.of(ablativeCase, accusativeCase).filter(Boolean::booleanValue).count() > 1) {
            throw new RuntimeException("only one case is accepted.");
        }

        final StringBuilder builder = new StringBuilder();
        builder.append(root);
        if (accusativeCase && feminineGender) {
            builder.append("ую");
        } else if (accusativeCase && neuterGender) {
            builder.append("ое");
        } else if (ablativeCase && feminineGender) {
            builder.append("ой");
        } else {
            throw new UnsupportedOperationException("Unhandled case");
        }

        return builder.toString();
    }
}
