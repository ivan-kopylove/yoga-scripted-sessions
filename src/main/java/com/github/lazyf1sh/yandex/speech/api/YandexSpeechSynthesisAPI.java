package com.github.lazyf1sh.yandex.speech.api;

import com.github.lazyf1sh.util.SessionParameters;
import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.github.lazyf1sh.yandex.speech.api.Voices.*;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

public final class YandexSpeechSynthesisAPI
{

    private static final Logger            LOGGER                = LoggerFactory.getLogger(YandexSpeechSynthesisAPI.class);
    private static final String            BASE_URL              = "https://tts.api.cloud.yandex.net/speech/v1/tts:synthesize";
    /**
     * Speech synthesis max text length limit from Yandex API side.
     */
    private static final int               YANDEX_API_TEXT_LIMIT = 4999;
    private final        SessionParameters sessionParameters;

    public YandexSpeechSynthesisAPI(SessionParameters sessionParameters)
    {

        this.sessionParameters = sessionParameters;
    }

    /**
     * The IAM token lifetime doesn't exceed 12 hours, but we recommend requesting the token more often, like once per hour.
     */
    public byte[] yandexSpeechGenerate(final String text, Voice voice) throws InterruptedException
    {
        if (text.length() > YANDEX_API_TEXT_LIMIT)
        {
            throw new RuntimeException();
        }

        final String token    = System.getenv("YC_API_KEY");
        final String folderId = System.getenv("YC_API_FOLDER_ID");

        final Client client = ClientBuilder.newClient();

        final WebTarget target = client.target(BASE_URL);

        final MultivaluedMap<String, String> voiceParam;
        switch (voice)
        {
            case JOHN:
                voiceParam = john();
                break;
            case ERMIL:
                voiceParam = ermil();
                break;
            case LEA:
                voiceParam = lea();
                break;
            case PHILIP:
                voiceParam = philip();
                break;
            case ALENA:
                voiceParam = alena();
                break;
            case MADIRUS:
                voiceParam = madirus();
                break;
            case JANE:
                voiceParam = jane();
                break;
            case ZAHAR:
                voiceParam = zahar();
                break;
            case OMAZH:
                voiceParam = omazh();
                break;

            default:
                throw new RuntimeException("fasdfsdf");
        }

        voiceParam.add("text", text);
        voiceParam.add("folderId", folderId);

        final Invocation.Builder request = target.request(APPLICATION_JSON);
        request.header("Authorization", "Bearer " + token);

        for (int i = 0; i < 6; i++)
        {
            try
            {
                final Response response = request.post(Entity.form(voiceParam));
                sessionParameters.yandexApiHitsIncrement();
                if (response.getStatus() != 200)
                {
                    LOGGER.error("Error calling yandex API: status {} {} {}",
                                 response.getStatus(),
                                 response,
                                 voiceParam);
                    throw new RuntimeException(response.toString());
                }
                return response.readEntity(byte[].class);
            }
            catch (RuntimeException e)
            {
                LOGGER.error("Error calling yandex API", e);
                Thread.sleep(1000);
                sessionParameters.yandexApiRetriesIncrement();
            }
        }


        throw new RuntimeException("failed to load using several attempts" + request);
    }
}
