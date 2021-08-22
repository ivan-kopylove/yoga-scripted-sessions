package com.github.lazyf1sh;

public class YogaConfig {
    private boolean sanscritMeaning;
    private String language;

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public boolean isSanscritMeaning() {
        return sanscritMeaning;
    }

    public void setSanscritMeaning(boolean sanscritMeaning) {
        this.sanscritMeaning = sanscritMeaning;
    }
}
