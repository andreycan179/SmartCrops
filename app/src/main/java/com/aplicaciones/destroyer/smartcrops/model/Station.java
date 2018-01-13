package com.aplicaciones.destroyer.smartcrops.model;

import java.io.Serializable;

/**
 * Created by Destroyer on 10/01/2018.
 */

public class Station  implements Serializable{

    private String key;
    private String kind;
    private double latitude;
    private double longitude;

    public Station() {
    }

    public Station(String key, String kind, double latitude, double longitude) {
        this.key = key;
        this.kind = kind;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
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
