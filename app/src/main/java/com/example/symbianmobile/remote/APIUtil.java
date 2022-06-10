package com.example.symbianmobile.remote;

public class APIUtil {

    private static final String API_URL = "http://10.107.144.20:3000/";

    public static RouterInterface getUserInterface(){

        return RetroFitClient.getClient(API_URL)
                .create(RouterInterface.class);

    }

}
