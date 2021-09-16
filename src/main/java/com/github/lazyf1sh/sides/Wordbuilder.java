package com.github.lazyf1sh.sides;

import java.util.stream.Stream;

public class Wordbuilder {

    boolean ablativeCase;
    boolean accusativeCase;
    boolean feminineGender;
    boolean masculineGender;
    boolean neuterGender;
    private String root;

    public Wordbuilder root(final String root) {
        this.root = root;
        return this;
    }

    public Wordbuilder accusative() {
        this.accusativeCase = true;
        return this;
    }

    public Wordbuilder ablative() {
        this.ablativeCase = true;
        return this;
    }

    public Wordbuilder feminine() {
        this.feminineGender = true;
        return this;
    }

    public Wordbuilder masculine() {
        this.masculineGender = true;
        return this;
    }

    public Wordbuilder neuter() {
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
        }
        if (accusativeCase && neuterGender) {
            builder.append("ое");
        }
        if (ablativeCase && feminineGender) {
            builder.append("ой");
        }


        return builder.toString();
    }
}
