package com.github.lazyf1sh.domain;

public class ReadAsanaParams
{
    private Class<?> resourceBundleClass;

    public static ReadAsanaParams readAsanaParams()
    {
        return new ReadAsanaParams();
    }

    public ReadAsanaParams resourceBundleClass(final Class<?> resourceBundleClass)
    {
        this.resourceBundleClass = resourceBundleClass;
        return this;
    }

    public Class<?> getResourceBundleClass()
    {
        return resourceBundleClass;
    }
}