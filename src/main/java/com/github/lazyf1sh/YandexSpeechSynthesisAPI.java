package com.github.lazyf1sh;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedHashMap;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.Response;

import javax.management.relation.RelationNotFoundException;

public class YandexSpeechSynthesisAPI
{

    private static final String BASE_URL              = "https://tts.api.cloud.yandex.net/speech/v1/tts:synthesize";
    /**
     * Speech synthesis limit.
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

        String token = "t1.9euelZqRnJTIz5Kcx8mamMaQkZWPy-3rnpWakpaUyY3Lj5uPi42ai5HHmsjl8_cMdkV8-e8fRT0l_t3z90wkQ3z57x9FPSX-.srEr0XKvJUVrsjVrO87QWE1FviKGErpMLn9TeGamDAqVvW8lZIX041NZOwhLCWaZ2unxEbzrouvSSfMWq4rYBw";
        String folderId = "b1g0vt1m6o1bapc66idu";

        Client client = ClientBuilder.newClient();

        WebTarget target = client.target(BASE_URL);

        MultivaluedMap<String, String> body = new MultivaluedHashMap<>();
        body.add("lang", "ru-RU");
        body.add("voice", "filipp");
        body.add("text", text);
        body.add("folderId", folderId);

        Invocation.Builder request = target.request(MediaType.APPLICATION_JSON);
        request.header("Authorization", "Bearer " + token);

        Response response = request.post(Entity.form(body));
        if (response.getStatus() != 200)
        {
            throw new RuntimeException();
        }
        return response.readEntity(byte[].class);
    }

}
