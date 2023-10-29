package com.github.lazyf1sh.asanas.named.outro;

import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.domain.Suite;

import java.io.IOException;
import java.util.List;

import static com.github.lazyf1sh.domain.ReadAsanaParams.readAsanaParams;
import static com.github.lazyf1sh.util.Util.readConventionalWay;

public class Outro implements Suite {

    public List<SourceFile> build() throws IOException {
        return List.of(readConventionalWay(readAsanaParams().resourceBundleClass(this.getClass())));
    }
}
