package com.example.weatherapprxjava;

import java.util.List;

public class Weather {


    private String name;
    private List<WeatherItem> weather;
    private Main main;

    public String getName() {
        return name;
    }

    public List<WeatherItem> getWeather() {
        return weather;
    }

    public Main getMain() {
        return main;
    }
}
