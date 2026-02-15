package com.github.lazyf1sh.domain;

import com.github.ivan.kopylove.commons.client.yandex.api.speech.Language;

import java.nio.file.Path;
import java.util.Objects;

public class SessionParameters
{

    private Path                   workingDir;
    private Language               language;
    private Class<? extends Suite> session;
    private int                    cacheHits;
    private int                    cacheOverwrites;
    private int                    totalLines;
    private int                    ruLines;
    private int                    enLines;
    private int                    skippedByChance;

    public Language getLanguage()
    {
        return language;
    }

    public void setLanguage(Language language)
    {
        this.language = language;
    }

    public int getTotalLines()
    {
        return totalLines;
    }

    public void totalLinesIncrement()
    {
        this.totalLines++;
    }

    public int getCacheOverwrites()
    {
        return cacheOverwrites;
    }

    public void incrementCacheOverwrites()
    {
        this.cacheOverwrites++;
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

    public SessionParameters setWorkingDir(Path workingDir)
    {
        Objects.requireNonNull(workingDir);
        this.workingDir = workingDir;
        return this;
    }

    public Path setWorkingDir()
    {
        Objects.requireNonNull(this.workingDir);
        return this.workingDir;
    }

    public Class<? extends Suite> setSession()
    {
        Objects.requireNonNull(session);
        return session;
    }

    public SessionParameters setSession(Class<? extends Suite> session)
    {
        Objects.requireNonNull(session);
        this.session = session;
        return this;
    }
}
