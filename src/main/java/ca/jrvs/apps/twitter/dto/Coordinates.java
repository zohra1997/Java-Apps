package ca.jrvs.apps.twitter.dto;

import java.util.List;

public class Coordinates {
    private double latitide;
    private double longitude;
    private List<Double> coordinates;

    public double getLatitide() {
        return latitide;
    }

    public List<Double> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
    }

    public void setLatitide(double latitide) {
        this.latitide = latitide;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
