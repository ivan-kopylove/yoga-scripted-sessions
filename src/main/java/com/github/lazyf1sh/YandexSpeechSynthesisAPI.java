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

        String token = "t1.9euelZqVmMqVnpKay4vNyYuSjJKQi-3rnpWakpaUyY3Lj5uPi42ai5HHmsjl9PcyGmZ4-e8cEl7k3fT3ckhjePnvHBJe5A.RhPuOkvpj-S7zuw8MdFolF3N5OtQl9oaRRaSwJCVL-eWilBtfDFvUDMre3gK6odeqTOHcYx9fAOcV4IE1We2Dw";
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