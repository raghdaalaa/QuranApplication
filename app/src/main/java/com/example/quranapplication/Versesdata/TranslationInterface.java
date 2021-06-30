package com.example.quranapplication.Versesdata;

import com.example.quranapplication.VersesModel.VerseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TranslationInterface {

    @GET("chapters/{chapter_id}/verses")
    public Call<VerseModel> getVersesTranslation(@Query("translations") int translations);

}
