package com.example.quranapplication.Versesdata;

import com.example.quranapplication.VersesModel.VerseModel;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface VersesInterface {

    @GET("chapters/{chapter_id}/verses")
    public Call<VerseModel> getVerses(@Path("chapter_id") int id ,@Query("page") int pageNumber);
}
