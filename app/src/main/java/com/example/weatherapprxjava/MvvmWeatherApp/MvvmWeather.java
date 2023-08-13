package com.example.weatherapprxjava.MvvmWeatherApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weatherapprxjava.MainActivity;
import com.example.weatherapprxjava.MvvmWeatherApp.ViewModel.WeatherViewModel;
import com.example.weatherapprxjava.R;

import java.security.PrivateKey;

public class MvvmWeather extends AppCompatActivity {
    Button button;
    TextView name,temp,hum,desc;
    EditText getname;
    private WeatherViewModel weatherViewModel;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvm_weather);
        button=findViewById(R.id.button1);
        getname=findViewById(R.id.getname1);
        name=findViewById(R.id.textCityName1);
        temp=findViewById(R.id.textTemperature1);
        hum=findViewById(R.id.textHumidity1);
        desc=findViewById(R.id.textDescription1);
        weatherViewModel=new ViewModelProvider(this).get(WeatherViewModel.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weatherViewModel.getWeatherLiveData().observe(MvvmWeather.this,weatherResponse -> {
                    String cityname=weatherResponse.getName();
                    String citytemp= String.valueOf(weatherResponse.getMain().getTemp());
                    String citydes=weatherResponse.getWeather().get(0).getDescription();
                    String cityhum= String.valueOf(weatherResponse.getMain().getHumidity());

                    Log.d("Weather", "City: " + cityname);
                    Log.d("Weather", "Temperature: " + citytemp);
                    Log.d("Weather", "Humidity: " + cityhum);
                    Log.d("Weather", "Description: " + citydes);

                    name.setText(cityname);
                    temp.setText(citytemp);
                    desc.setText(citydes);
                    hum.setText(cityhum);

                });


                String city = getname.getText().toString();
                String apiKey = "4a73bb5fc078fed3b922de2680ca89c0";
                Toast.makeText(MvvmWeather.this, city+" "+apiKey, Toast.LENGTH_SHORT).show();
                weatherViewModel.fetchWeather(city,apiKey);
            }
        });
    }
}