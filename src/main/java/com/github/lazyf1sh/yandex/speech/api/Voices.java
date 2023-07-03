package com.github.lazyf1sh.yandex.speech.api;

import jakarta.ws.rs.core.MultivaluedHashMap;
import jakarta.ws.rs.core.MultivaluedMap;

public final class Voices {

    public static MultivaluedMap<String, String> philip() {
        final MultivaluedMap<String, String> body = new MultivaluedHashMap<>();
        body.add("lang", "ru-RU");
        body.add("voice", "filipp");
        return body;
    }

    public static MultivaluedMap<String, String> alena() {
        final MultivaluedMap<String, String> body = new MultivaluedHashMap<>();
        body.add("lang", "ru-RU");
        body.add("voice", "alena");
        return body;
    }

    public static MultivaluedMap<String, String> ermil() {
        final MultivaluedMap<String, String> body = new MultivaluedHashMap<>();
        body.add("lang", "ru-RU");
        body.add("voice", "ermil");
        return body;
    }


}