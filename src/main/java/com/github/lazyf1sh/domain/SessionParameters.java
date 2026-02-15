package com.github.lazyf1sh.domain;


import java.nio.file.Path;
import java.util.Objects;

public class SessionParameters
{

    private Path                   workingDir;
    private LineLanguage           language;
    private double                 pauseMultiplier = 1.0;
    private double                 chanceMultiplier = 1.0;
    private Class<? extends Suite> session;
    private int                    cacheHits;
    private int                    cacheOverwrites;
    private int                    totalLines;
    private int                    ruLines;
    private int                    enLines;
    private int                    skippedByChance;

    public double getChanceMultiplier()
    {
        return chanceMultiplier;
    }

    public void setChanceMultiplier(double chanceMultiplier)
    {
        this.chanceMultiplier = chanceMultiplier;
    }

    public double getPauseMultiplier()
    {
        return pauseMultiplier;
    }

    public void setPauseMultiplier(double pauseMultiplier)
    {
        this.pauseMultiplier = pauseMultiplier;
    }

    public LineLanguage getLineLanguage()
    {
        if (language == null)
        {
            throw new RuntimeException("language is null");
        }
        return language;
    }

    public void setLanguage(LineLanguage language)
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

    public SessionParameters getWorkingDir(Path workingDir)
    {
        Objects.requireNonNull(workingDir);
        this.workingDir = workingDir;
        return this;
    }

    public Path getWorkingDir()
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
