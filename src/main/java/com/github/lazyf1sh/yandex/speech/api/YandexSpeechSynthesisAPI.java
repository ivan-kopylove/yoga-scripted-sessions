package com.github.lazyf1sh.yandex.speech.api;

import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.Response;

public final class YandexSpeechSynthesisAPI {

    private static final String BASE_URL = "https://tts.api.cloud.yandex.net/speech/v1/tts:synthesize";
    /**
     * Speech synthesis max text length limit from Yandex API side.
     */
    private static final int YANDEX_API_TEXT_LIMIT = 4999;

    /**
     * The IAM token lifetime doesn't exceed 12 hours, but we recommend requesting the token more often, like once per hour.
     */
    public static byte[] generate(final String text) {
        if (text.length() > YANDEX_API_TEXT_LIMIT) {
            throw new RuntimeException();
        }

        final String token = "t1.9euelZrMxs7KzMfJk8-Lz82TkJaOle3rnpWakpaUyY3Lj5uPi42ai5HHmsjl8_c6URxr-e8WE1Yj_d3z93p_GWv57xYTViP9.C9P-wI5svz0izdVoqkY3bHtvbFoKX4zUTn5yBNCl1Ulpys9vPj6XtXLiqwcvfFRBrCNsGASUGHECuk0ZWI8_Dg";
        final String folderId = "b1g0vt1m6o1bapc66idu";

        final Client client = ClientBuilder.newClient();

        final WebTarget target = client.target(BASE_URL);

        final MultivaluedMap<String, String> voice = Voices.philip();
        voice.add("text", text);
        voice.add("folderId", folderId);

        final Invocation.Builder request = target.request(MediaType.APPLICATION_JSON);
        request.header("Authorization", "Bearer " + token);

        final Response response = request.post(Entity.form(voice));
        if (response.getStatus() != 200)
        {
            throw new RuntimeException();
        }
        return response.readEntity(byte[].class);
    }

}
