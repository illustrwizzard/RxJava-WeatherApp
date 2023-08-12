package com.example.weatherapprxjava;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private WeatherManager weatherManager;
    Button button;
    TextView name,temp,hum,desc;
    EditText getname;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        getname=findViewById(R.id.getname);
        name=findViewById(R.id.textCityName);
        temp=findViewById(R.id.textTemperature);
        hum=findViewById(R.id.textHumidity);
        desc=findViewById(R.id.textDescription);
        weatherManager = new WeatherManager();
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("CheckResult")
            @Override
            public void onClick(View v) {



                String city = getname.getText().toString();
                String apiKey = "";
                Toast.makeText(MainActivity.this, city+" "+apiKey, Toast.LENGTH_SHORT).show();

                weatherManager.getWeather(city, apiKey)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(weather -> {
                            String cityname=weather.getName();
                            String citytemp= String.valueOf(weather.getMain().getTemp());
                            String citydes=weather.getWeather().get(0).getDescription();
                            String cityhum= String.valueOf(weather.getMain().getHumidity());

                            Log.d("Weather", "City: " + cityname);
                            Log.d("Weather", "Temperature: " + citytemp);
                            Log.d("Weather", "Humidity: " + cityhum);
                            Log.d("Weather", "Description: " + citydes);

                            name.setText(cityname);
                            temp.setText(citytemp);
                            desc.setText(citydes);
                            hum.setText(cityhum);


                            // Update UI with weather data
                        }, throwable -> {
                            // Handle error
                            Log.e("API Error", "Error fetching weather", throwable);
                            Toast.makeText(MainActivity.this, "failll", Toast.LENGTH_SHORT).show();
                        });
            }
        });

    }

    }
