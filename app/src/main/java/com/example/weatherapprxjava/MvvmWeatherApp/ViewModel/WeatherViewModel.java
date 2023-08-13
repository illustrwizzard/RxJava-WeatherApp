package com.example.weatherapprxjava.MvvmWeatherApp.ViewModel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.weatherapprxjava.MvvmWeatherApp.WeatherRepository;
import com.example.weatherapprxjava.MvvmWeatherApp.WeatherResponse;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class WeatherViewModel extends ViewModel {
    private WeatherRepository weatherRepository=new WeatherRepository();
    private MutableLiveData<WeatherResponse> weatherLiveData=new MutableLiveData<>();

     public LiveData<WeatherResponse>getWeatherLiveData(){
        return weatherLiveData;
    }

    public void fetchWeather(String city,String apikey){
        weatherRepository.fetchWeather(city,apikey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(weatherResponse -> {
                    weatherLiveData.setValue(weatherResponse);
                },throwable -> {

                });

    }

}
