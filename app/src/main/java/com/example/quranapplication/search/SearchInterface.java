package com.example.quranapplication.search;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SearchInterface {

    @GET("search")
    Call<Search> getResultOfSearch(@Query("q") String q,
                                   @Query("language") String language,
                                   @Query("page") int page);
}
