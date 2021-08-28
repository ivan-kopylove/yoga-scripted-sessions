package com.github.lazyf1sh.sides;

/**
 * Винительный падеж.
 * Accusative case - вижу кого, что? Правую руку.
 */
public class AccusativeСase {
    public String get(final Side side) {
        switch (side) {

            case LEFT:
                return "левую";
            case RIGHT:
                return "правую";

        }
        throw new RuntimeException("AccusativeСase");
    }
}
