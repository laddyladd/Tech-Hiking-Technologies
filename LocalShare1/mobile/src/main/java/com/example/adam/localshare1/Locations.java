package com.example.adam.localshare1;

import android.location.Location;

/**
 * Created by kristamcguigan on 4/28/16.
 */
public class Locations {
    private Location location;
    private Location current;
    private double longitude;
    private double latitude;

    public Locations(double longitude, double latitude)
    {

        this.longitude = longitude;
        this.latitude = latitude;

        location = new Location("");
        current = new Location("");

        location.setLongitude(longitude);
        location.setLatitude(latitude);
    }

    public void setCurrentLocation(Location currentLocation) {
        this.current = currentLocation;
    }
    public double getLong() {
        return longitude;
    }
    public double getLat() {
        return latitude;
    }
    public String getDistance(){
        return String.valueOf(current.distanceTo(location));
    }
    public Location getLoc()
    {
        return location;
    }
}
