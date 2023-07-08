package com.github.lazyf1sh.util;

import com.github.lazyf1sh.domain.Line;
import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.suits.CommonIntro;
import com.github.lazyf1sh.suits.Disclaimer;
import com.github.lazyf1sh.suits.Requisite;
import com.github.lazyf1sh.suits.Suite;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class Processor {

    private final ApplicationWideParameters applicationWideParameters;
    private final ToFileSaver toFileSaver;
    private final ShellExecutor shellExecutor;
    private static final Translator TRANSLATOR = new Translator();

    public Processor(ApplicationWideParameters applicationWideParameters, ToFileSaver toFileSaver, ShellExecutor shellExecutor) {
        this.applicationWideParameters = applicationWideParameters;
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

        List<SourceFile> sourceFileList;
        try {
            Suite suite = (Suite) applicationWideParameters.session().getDeclaredConstructor().newInstance();
            sourceFileList = suite.build();

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        Objects.requireNonNull(sourceFileList);
        result.addAll(sourceFileList);

//        result.add(new Outro().build());

        if (applicationWideParameters.isTranslateHaphazardly()) {
            TRANSLATOR.enrichWitTranslation(result);
        }
        toFileSaver.save(result);

        shellExecutor.exec("cmd.exe /c (for %i in (*.ogg) do @echo file '%i') > oggList.txt");
        shellExecutor.exec("ffmpeg -f concat -safe 0 -i oggList.txt -c copy oggFile.ogg");
        shellExecutor.exec("ffmpeg -i oggFile.ogg -vn -ar 44100 -ac 2 -b:a 192k " + applicationWideParameters.workingDir().getFileName() + ".mp3");
        shellExecutor.exec("cmd.exe /c del /S *.ogg");
        shellExecutor.exec("cmd.exe /c del /S oggList.txt");
    }

}
