package com.journaldev.retrofitintro;


import retrofit2.Call;
import retrofit2.http.GET;

import retrofit2.http.Query;

interface APIInterface {

    @GET("weather")
    Call<Weather> doGetListResources(@Query("q") String city, @Query("appid") String appid);
}

