package com.example.quranapplication.Chapterdata;

import com.example.quranapplication.pojo.QuranModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface QuranInterface {

    @GET("chapters")
    public  Call<QuranModel> getQuran(@Query("language") String language);
}
