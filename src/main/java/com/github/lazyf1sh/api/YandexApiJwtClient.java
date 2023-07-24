package com.github.lazyf1sh.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.net.http.HttpClient.Version.HTTP_1_1;
import static java.net.http.HttpClient.newHttpClient;

public class YandexApiJwtClient
{

    private static final Logger       LOGGER       = LoggerFactory.getLogger(YandexApiJwtClient.class);
    private static final String       API_URL      = "https://iam.api.cloud.yandex.net/iam/v1/tokens";
    private final        HttpClient   httPclient   = newHttpClient();
    private final        ObjectMapper objectMapper = new ObjectMapper();

    public String requestIamToken(final String signedJwt)
    {
        Objects.requireNonNull(signedJwt);
        if (signedJwt.isBlank())
        {
            throw new RuntimeException("text is blank");
        }

        final Map<String, String> payload = new HashMap<>();
        payload.put("jwt", signedJwt);


        try
        {
            final HttpRequest request = HttpRequest.newBuilder()
                                                   .version(HTTP_1_1)
                                                   .uri(URI.create(API_URL))
                                                   .header("Content-Type", "application/json")
                                                   .POST(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(
                                                           payload)))
                                                   .build();


            final HttpResponse<String> response = httPclient.send(request, HttpResponse.BodyHandlers.ofString());

            final ObjectNode node = objectMapper.readValue(response.body(), ObjectNode.class);

            final JsonNode data = node.get("iamToken");

            if (data == null)
            {
                return signedJwt;
            }
            return data.asText();
        }
        catch (final IOException | InterruptedException e)
        {
            LOGGER.error("http client request error", e);
            throw new RuntimeException(e);
        }
    }
}
