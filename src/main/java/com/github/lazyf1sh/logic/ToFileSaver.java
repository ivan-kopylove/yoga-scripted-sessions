package com.github.lazyf1sh.logic;

import com.github.lazyf1sh.domain.Line;
import com.github.lazyf1sh.domain.SessionParameters;
import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.domain.Voice;
import com.github.lazyf1sh.util.ShellExecutor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeoutException;

import static com.github.lazyf1sh.domain.Voice.*;

public class ToFileSaver
{

    private static final String            FILE_FORMAT         = "%05d.ogg";
    private final        VoiceProvider     voiceProvider;
    private final        SessionParameters sessionParameters;
    private final        ShellExecutor     shellExecutor;
    private final        ThreadLocalRandom THREAD_LOCAL_RANDOM = ThreadLocalRandom.current();

    public ToFileSaver(final SessionParameters sessionParameters, final ShellExecutor pauseGenerator, final VoiceProvider voiceProvider)
    {
        this.sessionParameters = sessionParameters;
        this.shellExecutor = pauseGenerator;
        this.voiceProvider = voiceProvider;
    }

    public void save(final List<SourceFile> piecesOfText) throws IOException, InterruptedException, ExecutionException, TimeoutException, NoSuchAlgorithmException
    {
        int rollingFileName = 0;
        Voice ruMainVoice = randomRuVoice();
        int voiceLines = THREAD_LOCAL_RANDOM.nextInt(10, 30);

        for (final SourceFile sourceFile : piecesOfText)
        {
            for (final Line line : sourceFile.getLines())
            {
                if (THREAD_LOCAL_RANDOM.nextDouble(0, 100) > line.chance())
                {
                    sessionParameters.skippedByChanceIncrement();
                    continue;
                }

                //                ruMainVoice = line.switchRuMainVoice() != PREVIOUS ? line.switchRuMainVoice() : ruMainVoice;

                if (voiceLines < 1)
                {
                    voiceLines = ThreadLocalRandom.current()
                                                  .nextInt(10, 30);
                    ruMainVoice = randomRuVoice();
                }

                switch (line.getLineType())
                {
                    case REGULAR:
                        if (line.de()
                                .isPresent())
                        {
                            final byte[] voice = voiceProvider.get(line.de()
                                                                       .orElseThrow(), LEA);
                            saveSingle(String.format(FILE_FORMAT, rollingFileName++),
                                       voice,
                                       sessionParameters.workingDir());
                            sessionParameters.deLinesIncrement();
                        }
                        else if (line.en()
                                     .isPresent())
                        {
                            final byte[] voice = voiceProvider.get(line.en()
                                                                       .orElseThrow(), JOHN);
                            saveSingle(String.format(FILE_FORMAT, rollingFileName++),
                                       voice,
                                       sessionParameters.workingDir());
                            sessionParameters.enLinesIncrement();
                        }
                        else
                        {
                            final byte[] voice = voiceProvider.get(line.ru(), ruMainVoice);
                            saveSingle(String.format(FILE_FORMAT, rollingFileName++),
                                       voice,
                                       sessionParameters.workingDir());
                            sessionParameters.ruLinesIncrement();
                        }
                        break;
                    case PAUSE:
                        final double seconds = (double) line.getPauseDuration() / 1000;
                        final String command = String.format("ffmpeg -f lavfi -i anullsrc -t %s -c:a libopus %s",
                                                             seconds,
                                                             String.format(FILE_FORMAT, rollingFileName++));
                        shellExecutor.exec(command);
                        break;
                }

                voiceLines--;
            }
        }
    }

    private void saveSingle(final String filename, final byte[] content, final Path directory) throws IOException
    {
        final Path file = Paths.get(directory.toString(), filename);

        Files.write(file, content);
    }
}