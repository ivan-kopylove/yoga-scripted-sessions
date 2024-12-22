package com.github.lazyf1sh.logic;

import com.github.lazyf1sh.asanas.named.outro.Outro;
import com.github.lazyf1sh.domain.SessionParameters;
import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.domain.Suite;
import com.github.lazyf1sh.logic.phrase.common.spi.CommonBeginningConfigurationSpi;
import com.github.lazyf1sh.logic.phrase.date.current.spi.BuildCurrentDateLineSpi;
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

import static java.nio.file.Files.createDirectories;

public class Processor {

    private static final Logger LOGGER = LoggerFactory.getLogger(Processor.class);

    private final SessionParameters sessionParameters;
    private final ToFileSaver toFileSaver;
    private final ShellExecutor shellExecutor;
    private final BuildCurrentDateLineSpi buildCurrentDateLineSpi;
    private final CommonBeginningConfigurationSpi commonBeginningConfigurationSpi;

    public Processor(SessionParameters sessionParameters, ToFileSaver toFileSaver, ShellExecutor shellExecutor, BuildCurrentDateLineSpi buildCurrentDateLineSpi, CommonBeginningConfigurationSpi commonBeginningConfigurationSpi) {
        this.sessionParameters = sessionParameters;
        this.toFileSaver = toFileSaver;
        this.shellExecutor = shellExecutor;
        this.buildCurrentDateLineSpi = buildCurrentDateLineSpi;
        this.commonBeginningConfigurationSpi = commonBeginningConfigurationSpi;
    }

    public void process() throws IOException, NoSuchAlgorithmException, ExecutionException, InterruptedException, TimeoutException {
        createDirectories(sessionParameters.workingDir());

        List<SourceFile> result = new ArrayList<>();

        result.add(buildCurrentDateLineSpi.callMe());
        result.addAll(commonBeginningConfigurationSpi.build());

        List<SourceFile> sourceFileList;
        try {
            Suite suite = sessionParameters.session()
                    .getDeclaredConstructor()
                    .newInstance();
            sourceFileList = suite.build();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            LOGGER.error("session instantiation error", e);
            throw new RuntimeException(e);
        }
        Objects.requireNonNull(sourceFileList);
        result.addAll(sourceFileList);

        result.addAll(new Outro().build());


        if (sessionParameters.isGenerateAudio()) {
            toFileSaver.save(result);
        }

        shellExecutor.exec("cmd.exe /c (for %i in (*.ogg) do @echo file '%i') > oggList.txt");
        shellExecutor.exec("ffmpeg -f concat -safe 0 -i oggList.txt -c copy oggFile.ogg");
        shellExecutor.exec("ffmpeg -i oggFile.ogg -vn -ar 44100 -ac 2 -b:a 192k " + sessionParameters.workingDir()
                .getFileName() + ".mp3");
        shellExecutor.exec("cmd.exe /c del /S *.ogg");
        shellExecutor.exec("cmd.exe /c del /S oggList.txt");
    }
}
