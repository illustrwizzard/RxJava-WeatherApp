package com.example.weatherapprxjava;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("weather")
    Observable<Weather> getWeather(@Query("q") String city, @Query("appid") String apiKey);
}
