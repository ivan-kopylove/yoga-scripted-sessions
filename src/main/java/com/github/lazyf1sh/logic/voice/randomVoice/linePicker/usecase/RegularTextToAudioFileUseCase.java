package com.github.lazyf1sh.logic.voice.randomVoice.linePicker.usecase;


import com.github.lazyf1sh.domain.Line;
import com.github.lazyf1sh.domain.SessionParameters;
import com.github.lazyf1sh.logic.VoiceProvider;
import com.github.lazyf1sh.logic.resource.files.saver.spi.SaveFileSpi;
import com.github.lazyf1sh.logic.voice.randomVoice.linePicker.api.RegularTextToAudioFileApi;
import com.github.lazyf1sh.logic.voice.randomVoice.spi.RandomRuVoicePickerSpi;

import static com.github.ivan.kopylove.commons.client.yandex.api.speech.Voice.JOHN;

public class RegularTextToAudioFileUseCase implements RegularTextToAudioFileApi {


    public static final String FILE_FORMAT = "%05d.ogg";


    private final VoiceProvider voiceProvider;
    private final SaveFileSpi saveFileSpi;
    private final RandomRuVoicePickerSpi randomRuVoicePickerSpi;
    private final SessionParameters sessionParameters;

    public RegularTextToAudioFileUseCase(VoiceProvider voiceProvider, SaveFileSpi saveFileSpi, RandomRuVoicePickerSpi randomRuVoicePickerSpi, SessionParameters sessionParameters) {
        this.voiceProvider = voiceProvider;
        this.saveFileSpi = saveFileSpi;
        this.randomRuVoicePickerSpi = randomRuVoicePickerSpi;
        this.sessionParameters = sessionParameters;
    }

    @Override
    public void save(Payload myPayload) {
        pickTextLine(myPayload.line(), myPayload.rollingFileName());
    }

    private void pickTextLine(Line line, int rollingFileName) {
        switch (line.lineLanguage()) {
            case RU -> {
                saveFileSpi.saveFile(
                        new SaveFileSpi.Payload(String.format(FILE_FORMAT, rollingFileName),
                                voiceProvider.get(line.ru(), randomRuVoicePickerSpi.randomRuVoice()),
                                sessionParameters.workingDir()));
                sessionParameters.ruLinesIncrement();
            }
            case EN -> {
                saveFileSpi.saveFile(
                        new SaveFileSpi.Payload(String.format(FILE_FORMAT, rollingFileName),
                                voiceProvider.get(line.en().orElseThrow(), JOHN),
                                sessionParameters.workingDir()));
                sessionParameters.enLinesIncrement();
            }
            case UNKNOWN -> {
                //
            }
        }
    }
}
