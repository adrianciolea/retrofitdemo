package com.evenlis.retrofitdemoweather.models;

/**
 *
 * Class is used for easier integration.
 * It has the Latitude and the longitude of a certain location
 *
 * Used in {@link com.evenlis.retrofitdemoweather.Locations}
 * Created by adrianciolea
 */
public class LatLang {
    public String longitude;
    public String latitude;

    public LatLang(String longitude, String latitude){
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
