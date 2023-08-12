package com.example.weatherapprxjava;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherManager {
    private ApiInterface weatherApi;

    public WeatherManager() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

        weatherApi = retrofit.create(ApiInterface.class);
    }

    public Observable<Weather> getWeather(String city, String apiKey) {
        return weatherApi.getWeather(city, apiKey);

    }
}
