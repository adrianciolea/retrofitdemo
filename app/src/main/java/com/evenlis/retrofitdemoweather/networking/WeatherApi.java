package com.evenlis.retrofitdemoweather.networking;

import com.evenlis.retrofitdemoweather.networking.responses.WeatherModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by adrianciolea on 31/1/18.
 */
public interface WeatherApi {

    /**
     * Call to get the wather for the latitude and longitude
     * @param longitude longitude of the place
     * @param latitude latitude of the place
     * @return a WeatherModel object that contains info about the weather
     */
    @GET("{longitude},{latitude}?exclude=[minutely,hourly,daily,alerts,flags]&units=si")
    Call<WeatherModel> getWeatherForLatLang(@Path("longitude") String longitude, @Path("latitude") String latitude);
}
