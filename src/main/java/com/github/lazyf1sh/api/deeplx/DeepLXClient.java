package com.github.lazyf1sh.api.deeplx;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class DeepLXClient
{

    private static final Logger LOGGER  = LoggerFactory.getLogger(DeepLXClient.class);
    private static final String API_URL = "http://127.0.0.1:1188/translate";

    final ObjectMapper objectMapper = new ObjectMapper();

    public String translate(String text)
    {
        if (text.length() < 1)
        {
            throw new RuntimeException("text.length() < 1");
        }

        Map<String, String> payload = new HashMap<>();
        payload.put("text", text);
        payload.put("source_lang", "RU");
        payload.put("target_lang", "EN");


        try
        {
            HttpRequest request2 = HttpRequest.newBuilder()
                                              .uri(new URI(API_URL))
                                              .POST(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(
                                                      payload)))
                                              .build();


            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> send = httpClient.send(request2, HttpResponse.BodyHandlers.ofString());

            ObjectNode node = objectMapper.readValue(send.body(), ObjectNode.class);

            JsonNode data = node.get("data");
            Thread.sleep(1000);
            if (data == null)
            {
                return text;
            }
            return data.asText();
        }
        catch (URISyntaxException | IOException | InterruptedException e)
        {
            LOGGER.error("http client request error", e);
            throw new RuntimeException(e);
        }
    }
}
