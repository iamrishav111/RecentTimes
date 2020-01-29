package com.example.recenttimes.api;

import com.example.recenttimes.Model.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiInterface {

    @GET("top-headlines")
    Call<News> getNews(@Query("country") String country,@Query("apiKey") String apiKey);


}
