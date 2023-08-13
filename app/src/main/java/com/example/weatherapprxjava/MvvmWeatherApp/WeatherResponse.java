package com.example.weatherapprxjava.MvvmWeatherApp;

import java.util.List;

public class WeatherResponse {
    private Main main;
    private List<WeatherItem> weather;
    private String name;

    public WeatherResponse(Main main, List<WeatherItem> weather, String name) {
        this.main = main;
        this.weather = weather;
        this.name = name;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public List<WeatherItem> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherItem> weather) {
        this.weather = weather;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
// Getters...
}

class Main {
    private double temp;
    private int humidity;

    public Main(double temp, int humidity) {
        this.temp = temp;
        this.humidity = humidity;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
    // Getters...
}

class WeatherItem {
    private String description;

    public WeatherItem(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    // Getters...
}
