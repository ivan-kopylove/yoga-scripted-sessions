package com.github.lazyf1sh.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

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

    private static final String API_URL = "http://127.0.0.1:1188/translate";

    final ObjectMapper objectMapper = new ObjectMapper();

    public String translate(final String text)
    {
        if (text.length() < 1)
        {
            throw new RuntimeException("text.length() < 1");
        }

        final Map<String, String> payload = new HashMap<>();
        payload.put("text", text);
        payload.put("source_lang", "RU");
        payload.put("target_lang", "EN");


        try
        {
            final HttpRequest request2 = HttpRequest.newBuilder()
                                                    .uri(new URI(API_URL))
                                                    .POST(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(
                                                            payload)))
                                                    .build();


            final HttpClient httpClient = HttpClient.newHttpClient();
            final HttpResponse<String> send = httpClient.send(request2, HttpResponse.BodyHandlers.ofString());


            final ObjectNode node = objectMapper.readValue(send.body(), ObjectNode.class);

            final JsonNode data = node.get("data");
            Thread.sleep(1000);
            if (data == null)
            {
                return text;
            }
            return data.asText();
        }
        catch (final URISyntaxException e)
        {
            throw new RuntimeException(e);
        }
        catch (final IOException e)
        {
            throw new RuntimeException(e);
        }
        catch (final InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }
}
