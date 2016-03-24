package Seller;

import Datastore.Coordinate;

/**
 * Kolten Sturgill
 * 1001089599
 * CSE 1325-002
 * 3/20/16.
 */
public class SellerUser {
    double longitude;
    double latitude;
    String name;
    Coordinate coordinate;

    public SellerUser(double mapX, double mapY, String name) {
        this.longitude = mapX;
        this.latitude = mapY;
        this.name = name;
        this.coordinate = new Coordinate(mapX,mapY);
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }


    @Override
    public String toString() {
        return latitude + "," + latitude + "," + name ;
    }
}
