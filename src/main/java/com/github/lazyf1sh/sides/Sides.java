package com.github.lazyf1sh.sides;

public final class Sides {

    private static final String LEFT_ROOT = "лев";
    private static final String RIGHT_ROOT = "прав";

    public static String leftAblativeFeminine() {
        return new Wordbuilder().ablative().feminine().root(LEFT_ROOT).build();
    }

    public static String leftAccusativeNeuter() {

        return new Wordbuilder().accusative().neuter().root(LEFT_ROOT).build();
    }

    public static String rightAblativeFeminine() {
        return new Wordbuilder().ablative().feminine().root(RIGHT_ROOT).build();
    }

    public static String rightAccusativeNeuter() {
        return new Wordbuilder().accusative().neuter().root(RIGHT_ROOT).build();
    }
}
