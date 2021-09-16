package com.github.lazyf1sh.sides;

import java.util.Objects;

import static com.github.lazyf1sh.sides.Sides.*;

public final class TextReplacer {

    public static String enrichSidePlaceHolder(final Side side, String text) {
        Objects.requireNonNull(side);
        Objects.requireNonNull(text);
        if ("".equals(text)) {
            throw new RuntimeException("dsadasd");
        }
        switch (side) {
            case LEFT_DEFAULT:
                text = text.replace("{{leftAccusativeNeuter}}", leftAccusativeNeuter());
                text = text.replace("{{leftAblativeFeminine}}", leftAblativeFeminine());
                break;
            case RIGHT:
                text = text.replace("{{rightAccusativeNeuter}}", rightAccusativeNeuter());
                text = text.replace("{{rightAblativeFeminine}}", rightAblativeFeminine());
                break;
        }

        if (text.contains("{{") || text.contains("}}")) {
            throw new RuntimeException("{{ or }}");
        }
        return text;
    }
}
