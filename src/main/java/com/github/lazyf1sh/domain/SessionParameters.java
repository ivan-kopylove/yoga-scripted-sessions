package com.github.lazyf1sh.domain;

import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SessionParameters
{

    private final ExecutorService        streamGobblerPool = Executors.newFixedThreadPool(2);
    private       Path                   workingDir;
    private       Class<? extends Suite> session;
    private       boolean                translateHaphazardly;
    private       boolean                generateAudio;
    private       int                    yandexApiHits;
    private       int                    cacheHits;
    private       int                    totalLines;
    private       int                    ruLines;
    private       int                    enLines;
    private       int                    yandexApiRetries;
    private       int                    skippedByChance;
    private       String                 yandexApiToken;
    private       String                 yandexApiFolderId;

    public int getTotalLines()
    {
        return totalLines;
    }

    public void totalLinesIncrement()
    {
        this.totalLines++;
    }

    public boolean isGenerateAudio()
    {
        return generateAudio;
    }

    public void setGenerateAudio(final boolean generateAudio)
    {
        this.generateAudio = generateAudio;
    }

    public int getCacheHits()
    {
        return cacheHits;
    }

    public int getRuLines()
    {
        return ruLines;
    }

    public void ruLinesIncrement()
    {
        this.ruLines++;
    }

    public int getEnLines()
    {
        return enLines;
    }

    public void enLinesIncrement()
    {
        this.enLines++;
    }

    public void cacheHitsIncrement()
    {
        this.cacheHits++;
    }

    public int getSkippedByChance()
    {
        return skippedByChance;
    }

    public void skippedByChanceIncrement()
    {
        this.skippedByChance++;
    }

    public int getYandexApiHits()
    {
        return yandexApiHits;
    }

    public void yandexApiHitsIncrement()
    {
        this.yandexApiHits++;
    }

    public int getYandexApiRetries()
    {
        return yandexApiRetries;
    }

    public void yandexApiRetriesIncrement()
    {
        this.yandexApiRetries++;
    }

    public boolean isTranslateHaphazardly()
    {
        return translateHaphazardly;
    }

    public void setTranslateHaphazardly(final boolean translateHaphazardly)
    {
        this.translateHaphazardly = translateHaphazardly;
    }

    public SessionParameters workingDir(final Path workingDir)
    {
        this.workingDir = workingDir;
        return this;
    }

    public Path workingDir()
    {
        return this.workingDir;
    }

    public ExecutorService getStreamGobblerPool()
    {
        return streamGobblerPool;
    }

    public Class<? extends Suite> session()
    {
        return session;
    }

    public SessionParameters session(final Class<? extends Suite> session)
    {
        this.session = session;
        return this;
    }

    public String getYandexApiToken()
    {
        return yandexApiToken;
    }

    public void setYandexApiToken(String yandexApiToken)
    {
        this.yandexApiToken = yandexApiToken;
    }

    public String getYandexApiFolderId()
    {
        return yandexApiFolderId;
    }

    public void setYandexApiFolderId(String yandexApiFolderId)
    {
        this.yandexApiFolderId = yandexApiFolderId;
    }
}
