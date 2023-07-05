package com.github.lazyf1sh.util;

import com.github.lazyf1sh.domain.Line;
import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.suits.CommonIntro;
import com.github.lazyf1sh.suits.Disclaimer;
import com.github.lazyf1sh.suits.Requisite;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class Processor {

    private ToFileSaver toFileSaver;
    private final ShellExecutor shellExecutor;
    private static final Translator TRANSLATOR = new Translator();

    public Processor(ToFileSaver toFileSaver, ShellExecutor shellExecutor) {
        this.toFileSaver = toFileSaver;
        this.shellExecutor = shellExecutor;
    }

    public void process() throws IOException, NoSuchAlgorithmException, ExecutionException, InterruptedException, TimeoutException {
        final List<SourceFile> result = new ArrayList<>();
        result.add(new SourceFile(null, List.of(new Line("{\"ru\": \"Старт.\"}"))));
        result.add(new SourceFile(null, List.of(new Line("sil<[40000]>"))));
        result.add(new Disclaimer().build());
        result.add(new Requisite().build());
        result.addAll(new CommonIntro().build());

//        final List<SourceFile> session = suryaNamaskar();
//        final List<SourceFile> session = hipsOpening();
//        final List<SourceFile> session = bends();
//        result.addAll(session);

//        result.add(new Outro().build());

//        TRANSLATOR.enrichWitTranslation(result);

        toFileSaver.save(result);

        shellExecutor.exec("cmd.exe /c (for %i in (*.ogg) do @echo file '%i') > oggList.txt");
        shellExecutor.exec("ffmpeg -f concat -safe 0 -i oggList.txt -c copy output.ogg");
    }

}
