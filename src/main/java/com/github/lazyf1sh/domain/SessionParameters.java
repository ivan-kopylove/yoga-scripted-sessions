package com.github.lazyf1sh.domain;

import java.nio.file.Path;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SessionParameters
{

    private final ExecutorService        streamGobblerPool = Executors.newFixedThreadPool(2);
    private       Path                   workingDir;
    private       Class<? extends Suite> session;
    private       int                    cacheHits;
    private       int                    totalLines;
    private       int                    ruLines;
    private       int                    enLines;
    private       int                    skippedByChance;

    public int getTotalLines()
    {
        return totalLines;
    }

    public void totalLinesIncrement()
    {
        this.totalLines++;
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




    public SessionParameters workingDir(Path workingDir)
    {
        Objects.requireNonNull(workingDir);
        this.workingDir = workingDir;
        return this;
    }

    public Path workingDir()
    {
        Objects.requireNonNull(this.workingDir);
        return this.workingDir;
    }

    public ExecutorService getStreamGobblerPool()
    {
        return streamGobblerPool;
    }

    public Class<? extends Suite> session()
    {
        Objects.requireNonNull(session);
        return session;
    }

    public SessionParameters session(Class<? extends Suite> session)
    {
        Objects.requireNonNull(session);
        this.session = session;
        return this;
    }


}
