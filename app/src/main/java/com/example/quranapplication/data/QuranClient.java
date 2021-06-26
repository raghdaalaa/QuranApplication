package com.example.quranapplication.data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuranClient {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://quran.api-docs.io/v3/";



    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build();
        }

        return retrofit;
    }
}



