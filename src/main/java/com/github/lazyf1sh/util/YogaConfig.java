package com.github.lazyf1sh.util;

public class YogaConfig {
    private boolean sanscritMeaning;
    private String language;

    public YogaConfig() {
    }


    public YogaConfig(final boolean sanscritMeaning, final String language) {
        this.sanscritMeaning = sanscritMeaning;
        this.language = language;
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
