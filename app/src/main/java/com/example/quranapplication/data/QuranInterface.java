package com.example.quranapplication.data;

import com.example.quranapplication.pojo.Chapter;
import com.example.quranapplication.pojo.QuranModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface QuranInterface {

    @GET("chapters/list-chapters")
    public  Call<QuranModel> getQuran();
}
