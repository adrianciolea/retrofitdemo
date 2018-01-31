package com.evenlis.retrofitdemoweather;

import com.evenlis.retrofitdemoweather.networking.ApiUtils;
import com.evenlis.retrofitdemoweather.networking.responses.WeatherModel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        final TextView bodyText = findViewById(R.id.body_text);
        // Here we make the call for using Cairo's longitude and latitude
        ApiUtils.getApiManager().getWeatherForLatLang(Locations.CAIRO.longitude, Locations.CAIRO.latitude).enqueue(new Callback<WeatherModel>() {
            @Override
            public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
                bodyText.setText(new StringBuilder().append(response.body().getTimezone()).append(" - ")
                                                    .append(response.body().getCurrently().getApparentTemperature()).append(" Degrees ")
                                                    .append("Celsius").toString());

                // response.body is a WeatherModel Object and it contains data about the weather
            }

            @Override
            public void onFailure(Call<WeatherModel> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
