package com.github.lazyf1sh.logic;

import com.github.lazyf1sh.asanas.named.commonWarump.CommonWarmup;
import com.github.lazyf1sh.asanas.named.outro.Outro;
import com.github.lazyf1sh.domain.Line;
import com.github.lazyf1sh.domain.SessionParameters;
import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.domain.Suite;
import com.github.lazyf1sh.util.ShellExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import static com.github.lazyf1sh.asanas.named.Disclaimer.disclaimer;
import static com.github.lazyf1sh.asanas.named.Requisite.requisite;
import static java.nio.file.Files.createDirectories;

public class Processor
{

    private static final Logger LOGGER = LoggerFactory.getLogger(Processor.class);

    private final SessionParameters sessionParameters;
    private final ToFileSaver       toFileSaver;
    private final ShellExecutor     shellExecutor;
    private final Translator        translator;

    public Processor(final SessionParameters sessionParameters, final ToFileSaver toFileSaver, final ShellExecutor shellExecutor, final Translator translator)
    {
        this.sessionParameters = sessionParameters;
        this.toFileSaver = toFileSaver;
        this.shellExecutor = shellExecutor;
        this.translator = translator;
    }

    public void process() throws IOException, NoSuchAlgorithmException, ExecutionException, InterruptedException, TimeoutException
    {
        createDirectories(sessionParameters.workingDir());

        final List<SourceFile> result = new ArrayList<>();
        result.add(new SourceFile(null, List.of(new Line("{\"ru\": \"Старт.\"}"))));
        result.add(new SourceFile(null, List.of(new Line("sil<[40000]>"))));
        result.add(disclaimer());
        result.add(requisite());
        result.addAll(new CommonWarmup().build());

        final List<SourceFile> sourceFileList;
        try
        {
            final Suite suite = sessionParameters.session()
                                                 .getDeclaredConstructor()
                                                 .newInstance();
            sourceFileList = suite.build();
        }
        catch (final InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e)
        {
            LOGGER.error("session instantiation error", e);
            throw new RuntimeException(e);
        }
        Objects.requireNonNull(sourceFileList);
        result.addAll(sourceFileList);

        result.add(new Outro().build());

        if (sessionParameters.isTranslateHaphazardly())
        {
            translator.enrichWithTranslation(result);
        }
        toFileSaver.save(result);

        shellExecutor.exec("cmd.exe /c (for %i in (*.ogg) do @echo file '%i') > oggList.txt");
        shellExecutor.exec("ffmpeg -f concat -safe 0 -i oggList.txt -c copy oggFile.ogg");
        shellExecutor.exec("ffmpeg -i oggFile.ogg -vn -ar 44100 -ac 2 -b:a 192k " + sessionParameters.workingDir()
                                                                                                     .getFileName() + ".mp3");
        shellExecutor.exec("cmd.exe /c del /S *.ogg");
        shellExecutor.exec("cmd.exe /c del /S oggList.txt");
    }
}