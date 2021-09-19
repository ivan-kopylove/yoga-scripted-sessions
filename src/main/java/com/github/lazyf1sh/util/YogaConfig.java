package com.github.lazyf1sh.util;

import com.github.lazyf1sh.sides.Side;

import static com.github.lazyf1sh.sides.Side.LEFT_DEFAULT;

public class YogaConfig {
    private boolean sanscritMeaning;
    private String language;
    private Side side = LEFT_DEFAULT;

    public YogaConfig() {
    }


    public YogaConfig(final boolean sanscritMeaning, final String language) {
        this.sanscritMeaning = sanscritMeaning;
        this.language = language;
    }

    public YogaConfig(final boolean sanscritMeaning, final String language, final Side side) {
        this.sanscritMeaning = sanscritMeaning;
        this.language = language;
        this.side = side;
    }


    public Side getSide() {
        return side;
    }

    public void setSide(final Side side) {
        this.side = side;
    }

    public void setLanguage(final String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public boolean isSanscritMeaning() {
        return sanscritMeaning;
    }

    public void setSanscritMeaning(final boolean sanscritMeaning) {
        this.sanscritMeaning = sanscritMeaning;
    }

}
