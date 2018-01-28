package com.aplicaciones.destroyer.smartcrops.model;

import java.io.Serializable;

/**
 * Created by Destroyer on 10/01/2018.
 */

public class Station  implements Serializable{

    private String name;
    private String function;
    private double latitude;
    private double longitude;

    public Station() {
    }

    public Station(String name, String function, double latitude, double longitude) {
        this.name = name;
        this.function = function;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
