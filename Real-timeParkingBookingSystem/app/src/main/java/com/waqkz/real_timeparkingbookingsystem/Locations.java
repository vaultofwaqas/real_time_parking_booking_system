package com.waqkz.real_timeparkingbookingsystem;

/**
 * Created by waqkz on 1/27/17.
 */

public class Locations {

    private String LocationName;

    public Locations() {
    }

    public Locations(String locationName) {
        LocationName = locationName;
    }

    public String getLocationName() {
        return LocationName;
    }

    public void setLocationName(String locationName) {
        LocationName = locationName;
    }
}
