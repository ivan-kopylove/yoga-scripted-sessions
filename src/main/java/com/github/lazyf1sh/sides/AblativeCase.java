package com.github.lazyf1sh.sides;

/**
 * Творительный падеж. Доволен кем, чем? Правой рукой.
 */
public class AblativeCase {

    public String get(final Side side) {
        switch (side) {
            case LEFT:
                return "левой";
            case RIGHT:
                return "правой";
        }
        throw new RuntimeException("AblativeCase");
    }


}
