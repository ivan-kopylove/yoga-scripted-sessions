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

                text = text.replace("{{rightAccusativeNeuter}}", rightAccusativeNeuter());
                text = text.replace("{{rightAblativeFeminine}}", rightAblativeFeminine());
                break;
            case RIGHT:
                text = text.replace("{{leftAccusativeNeuter}}", rightAccusativeNeuter());
                text = text.replace("{{leftAblativeFeminine}}", rightAblativeFeminine());

                text = text.replace("{{rightAccusativeNeuter}}", leftAccusativeNeuter());
                text = text.replace("{{rightAblativeFeminine}}", leftAblativeFeminine());
                break;
        }

        return text;
    }
}
