package com.github.lazyf1sh.util;

import com.github.lazyf1sh.suits.Suite;

import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SessionParameters {

    private Path workingDir;
    private final ExecutorService streamGobblerPool = Executors.newFixedThreadPool(2);
    private Class<? extends Suite> session;
    private boolean translateHaphazardly;
    private int yandexApiHits;
    private int yandexApiRetries;
    private int skippedByChance;

    public int getSkippedByChance() {
        return skippedByChance;
    }

    public void skippedByChanceIncrement() {
        this.skippedByChance++;
    }

    public int getYandexApiHits() {
        return yandexApiHits;
    }

    public void yandexApiHitsIncrement() {
        this.yandexApiHits++;
    }

    public int getYandexApiRetries() {
        return yandexApiRetries;
    }

    public void yandexApiRetriesIncrement() {
        this.yandexApiRetries++;
    }

    public boolean isTranslateHaphazardly() {
        return translateHaphazardly;
    }

    public void setTranslateHaphazardly(boolean translateHaphazardly) {
        this.translateHaphazardly = translateHaphazardly;
    }

    public SessionParameters workingDir(Path workingDir) {
        this.workingDir = workingDir;
        return this;
    }

    public Path workingDir() {
        return this.workingDir;
    }


    public ExecutorService getStreamGobblerPool() {
        return streamGobblerPool;
    }

    public Class<? extends Suite> session() {
        return session;
    }
     public SessionParameters session(Class<? extends Suite> session) {
        this.session = session;
        return this;
    }


}
