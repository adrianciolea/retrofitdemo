package com.evenlis.retrofitdemoweather.networking;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Helper Class
 *
 * Created by adrianciolea
 */
public class ApiUtils {

    private final static String BASE_URL = "https://api.darksky.net/forecast/";
    //TODO: Put your appy key there
    private final static String API_KEY = "YOUR_API_KEY_HERE";
    /**
     * This is a Logging interceptor. It incercepts all the traffic from our client and logs the body for easier debugging
     */
    private static HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();

    /**
     * Returns a client ready to make the call
     */
    public static WeatherApi getApiManager() {
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL + API_KEY + "/").client(client)
                                                  .addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(WeatherApi.class);
    }
}
