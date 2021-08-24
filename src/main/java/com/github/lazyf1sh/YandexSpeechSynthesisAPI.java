package com.github.lazyf1sh;

import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.Response;

public class YandexSpeechSynthesisAPI
{

    private static final String BASE_URL              = "https://tts.api.cloud.yandex.net/speech/v1/tts:synthesize";
    /**
     * Speech synthesis max text length limit from Yandex API side.
     */
    private static final int    YANDEX_API_TEXT_LIMIT = 4999;

    /**
     * The IAM token lifetime doesn't exceed 12 hours, but we recommend requesting the token more often, like once per hour.
     */
    public static byte[] generate(String text)
    {
        if (text.length() > YANDEX_API_TEXT_LIMIT)
        {
            throw new RuntimeException();
        }

        String token = "t1.9euelZqSzMvKjYqak5WckM_JyZqWzu3rnpWakpaUyY3Lj5uPi42ai5HHmsjl9PdWC252-e9FPiGO3fT3FjprdvnvRT4hjg.aDDRBvmRkbpt0a_8t11fsCIatm9hXOF1igoxv63QbMe036r9m0h8P050zEMRhlMYX--jaa_Y4m8URAGQeuchAw";
        String folderId = "b1g0vt1m6o1bapc66idu";

        Client client = ClientBuilder.newClient();

        WebTarget target = client.target(BASE_URL);

        MultivaluedMap<String, String> voice = Voices.philip();
        voice.add("text", text);
        voice.add("folderId", folderId);

        Invocation.Builder request = target.request(MediaType.APPLICATION_JSON);
        request.header("Authorization", "Bearer " + token);

        Response response = request.post(Entity.form(voice));
        if (response.getStatus() != 200)
        {
            throw new RuntimeException();
        }
        return response.readEntity(byte[].class);
    }

}
