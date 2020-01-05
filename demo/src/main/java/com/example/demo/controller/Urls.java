package com.example.demo.controller;

public final class Urls {

    private static final String API_PREFIX = "/api/{version}/";
    public static final String LOGIN_URL = API_PREFIX + "login";
    public static final String SHOW_TITLE = API_PREFIX + "question/list";

    public static class Version {
        public static final int V1 = 1;
        public static final int V2 = 2;
        public static final int V3 = 3;
    }
}

