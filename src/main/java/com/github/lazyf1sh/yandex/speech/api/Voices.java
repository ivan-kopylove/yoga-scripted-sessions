package com.github.lazyf1sh.yandex.speech.api;

import jakarta.ws.rs.core.MultivaluedHashMap;
import jakarta.ws.rs.core.MultivaluedMap;

public final class Voices
{

    public static MultivaluedMap<String, String> philip()
    {
        final MultivaluedMap<String, String> body = new MultivaluedHashMap<>();
        body.add("lang", "ru-RU");
        body.add("voice", "filipp");
        return body;
    }

    public static MultivaluedMap<String, String> alena()
    {
        final MultivaluedMap<String, String> body = new MultivaluedHashMap<>();
        body.add("lang", "ru-RU");
        body.add("voice", "alena");
        return body;
    }

    public static MultivaluedMap<String, String> madirus()
    {
        final MultivaluedMap<String, String> body = new MultivaluedHashMap<>();
        body.add("lang", "ru-RU");
        body.add("voice", "madirus");
        return body;
    }

    public static MultivaluedMap<String, String> zahar()
    {
        final MultivaluedMap<String, String> body = new MultivaluedHashMap<>();
        body.add("lang", "ru-RU");
        body.add("voice", "zahar");
        return body;
    }

    public static MultivaluedMap<String, String> omazh()
    {
        final MultivaluedMap<String, String> body = new MultivaluedHashMap<>();
        body.add("lang", "ru-RU");
        body.add("voice", "omazh");
        return body;
    }

    public static MultivaluedMap<String, String> jane()
    {
        final MultivaluedMap<String, String> body = new MultivaluedHashMap<>();
        body.add("lang", "ru-RU");
        body.add("voice", "jane");
        return body;
    }


    public static MultivaluedMap<String, String> ermil()
    {
        final MultivaluedMap<String, String> body = new MultivaluedHashMap<>();
        body.add("lang", "ru-RU");
        body.add("voice", "ermil");
        return body;
    }

    public static MultivaluedMap<String, String> lea()
    {
        final MultivaluedMap<String, String> body = new MultivaluedHashMap<>();
        body.add("lang", "de-DE");
        body.add("voice", "lea");
        return body;
    }


    public static MultivaluedMap<String, String> john()
    {
        final MultivaluedMap<String, String> body = new MultivaluedHashMap<>();
        body.add("lang", "en-US");
        body.add("voice", "john");
        return body;
    }


}

