package com.github.lazyf1sh.asanas.named.vibroGymnastics;

import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.domain.Suite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.github.lazyf1sh.domain.ReadAsanaParams.readAsanaParams;
import static com.github.lazyf1sh.util.Util.readConventionalWay;

/**
 * Recover mindgames chemistry:
 * - <a href="https://www.google.com/search?q=%22the+hands+for+a+few+seconds+until+they+get+hot">...</a>
 */
public class VibroGymnastics implements Suite
{

    public List<SourceFile> build() throws IOException
    {
        List<SourceFile> result = new ArrayList<>();

        result.add(readConventionalWay(readAsanaParams().resourceBundleClass(this.getClass())));


        return result;
    }
}
