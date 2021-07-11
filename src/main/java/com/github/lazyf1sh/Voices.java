package com.github.lazyf1sh;

import jakarta.ws.rs.core.MultivaluedHashMap;
import jakarta.ws.rs.core.MultivaluedMap;

public class Voices {

    public static MultivaluedMap<String, String> philip() {
        MultivaluedMap<String, String> body = new MultivaluedHashMap<>();
        body.add("lang", "ru-RU");
        body.add("voice", "filipp");
        return body;
    }

    public static MultivaluedMap<String, String> nick() {
        MultivaluedMap<String, String> body = new MultivaluedHashMap<>();
        body.add("lang", "en-US");
        body.add("voice", "nick");
        return body;
    }
}