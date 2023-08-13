package com.example.weatherapprxjava.MvvmWeatherApp;

import com.example.weatherapprxjava.ApiInterface;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherRepository {
    private ApiInterface apiInterface;

    public WeatherRepository(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

        apiInterface=retrofit.create(ApiInterface.class);
    }

    public Observable<WeatherResponse> fetchWeather(String city, String apikey){
        return apiInterface.getWeatherResponse(city,apikey);
    }
}
