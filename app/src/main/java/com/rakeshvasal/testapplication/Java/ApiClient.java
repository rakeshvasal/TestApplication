package com.rakeshvasal.testapplication.Java;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit = null;
    private static String BASE_URL = "https://cricket.yahoo.net/sifeeds/cricket/live/json/";
    //private static String BASE_URL = "http://unitypuzzlegame.com/";

    public static Retrofit getClient() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            return retrofit;
        } else {
            return retrofit;
        }
    }
}
