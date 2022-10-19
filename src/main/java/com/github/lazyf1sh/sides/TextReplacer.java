package com.github.lazyf1sh.sides;

import java.util.Objects;

import static com.github.lazyf1sh.sides.Sides.*;

public final class TextReplacer {

    public static String enrichSidePlaceHolder(final Side side, String text) {
        Objects.requireNonNull(side);
        Objects.requireNonNull(text);
        if ("".equals(text)) {
            throw new RuntimeException("Unhandled exception - empty text");
        }
        switch (side) {
            case LEFT_DEFAULT:
                text = text.replace("{{left.accusative.neuter}}", leftAccusativeNeuter());
                text = text.replace("{{left.ablative.feminine}}", leftAblativeFeminine());

                text = text.replace("{{right.accusative.neuter}}", rightAccusativeNeuter());
                text = text.replace("{{right.ablative.feminine}}", rightAblativeFeminine());
                break;
            case RIGHT:
                text = text.replace("{{left.accusative.neuter}}", rightAccusativeNeuter());
                text = text.replace("{{left.ablative.feminine}}", rightAblativeFeminine());

                text = text.replace("{{right.accusative.neuter}}", leftAccusativeNeuter());
                text = text.replace("{{right.ablative.feminine}}", leftAblativeFeminine());
                break;
        }

        return text;
    }
}
