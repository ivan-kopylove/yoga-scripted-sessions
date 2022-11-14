package com.github.lazyf1sh.sides;

import java.util.Objects;

import static com.github.lazyf1sh.sides.WordBuilder.*;

public final class TextReplacer {

    public static String enrichSidePlaceHolder(final Side side, String text) {
        Objects.requireNonNull(side);
        Objects.requireNonNull(text);
        if ("".equals(text)) {
            throw new RuntimeException("Unhandled exception - empty text");
        }
        switch (side) {
            case LEFT_DEFAULT:
                text = text.replace("{{left.accusative.neuter}}", wordBuilder().accusative().neuter().root(LEFT_ROOT).build());
                text = text.replace("{{left.accusative.feminine}}", wordBuilder().accusative().feminine().root(LEFT_ROOT).build());
                text = text.replace("{{left.ablative.feminine}}", wordBuilder().ablative().feminine().root(LEFT_ROOT).build());
                text = text.replace("{{left.prepositional.masculine}}", wordBuilder().ablative().feminine().root(LEFT_ROOT).build());

                text = text.replace("{{right.accusative.neuter}}", wordBuilder().accusative().neuter().root(RIGHT_ROOT).build());
                text = text.replace("{{right.accusative.feminine}}", wordBuilder().accusative().feminine().root(RIGHT_ROOT).build());
                text = text.replace("{{right.ablative.feminine}}", wordBuilder().ablative().feminine().root(RIGHT_ROOT).build());
                text = text.replace("{{right.prepositional.masculine}}", wordBuilder().ablative().feminine().root(RIGHT_ROOT).build());
                break;
            case RIGHT:
                text = text.replace("{{left.accusative.neuter}}", wordBuilder().accusative().neuter().root(RIGHT_ROOT).build());
                text = text.replace("{{left.accusative.feminine}}", wordBuilder().accusative().feminine().root(RIGHT_ROOT).build());
                text = text.replace("{{left.ablative.feminine}}", wordBuilder().ablative().feminine().root(RIGHT_ROOT).build());
                text = text.replace("{{left.prepositional.masculine}}", wordBuilder().ablative().feminine().root(RIGHT_ROOT).build());

                text = text.replace("{{right.accusative.neuter}}", wordBuilder().accusative().neuter().root(LEFT_ROOT).build());
                text = text.replace("{{right.accusative.feminine}}", wordBuilder().accusative().feminine().root(LEFT_ROOT).build());
                text = text.replace("{{right.ablative.feminine}}", wordBuilder().ablative().feminine().root(LEFT_ROOT).build());
                text = text.replace("{{right.prepositional.masculine}}", wordBuilder().ablative().feminine().root(LEFT_ROOT).build());
                break;
        }

        return text;
    }
}
