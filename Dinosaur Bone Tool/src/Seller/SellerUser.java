package Seller;

import Datastore.Coordinate;

/**
 * SellerUser.java
 * Daniel Delago
 * Kolten Sturgill
 * 1001060927
 * 1001089599
 *
 * The SellerUser class is the class that defines the Seller (user) model
 *
 * Data Members:
 * double longitude, double latitude, String name, Coordinate coordinate
 *
 * Functions:
 * public SellerUser(double mapX, double mapY, String name)
 * Two double parameters, one String, nothing returned,
 * Creates new instance of SellerUser object. A Coordinate object
 * is created when an instance of SellerUser is made by passing
 * a longitude and latitude defined as the arguments.
 *
 * public SellerUser(String[] csv)
 * Takes one string array parameter, nothing is returned.
 * Creates new instance of SellerUser object from the csv file
 * sellers.csv from LoadFile.java A Coordinate object
 * is created when an instance of SellerUser is made by passing
 * a longitude and latitude defined as the arguments.
 *
 * public double getLongitude()
 * No parameters, returns an data member longitude to an
 * instance of SellerUser of type double.
 * This is a getter, auto generated code.
 *
 * public void setLongitude(double longitude)
 * Single parameter of type double, does not return any value
 * Overwrites the original value of the instance that was previously
 * instantiated.
 *
 * public double getLatitude()
 * No parameters passed, returns the data member latitude to
 * an instance of SellerUser of type double.
 *
 * public void setLatitude(double latitude)
 * Single parameter of type double, does not return any value
 * Overwrites the original value of the instance that was previously
 * instantiated.
 *
 * public String getName()
 * No parameters passed, returns the data member name to
 * an instance of SellerUser of type String.
 *
 * public void setName(String name)
 * Single parameter of type String, does not return any value
 * Overwrites the original value of the instance that was previously
 * instantiated.
 *
 * public Coordinate getCoordinate()
 * No parameters passed, returns the data member name to
 * an instance of SellerUser of type Coordinate.
 *
 * public setCoordinate(Coordinate coordinate)
 * Single parameter of type Coordinate, does not return any value
 * Overwrites the original value of the instance that was previously
 * instantiated.
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

    public SellerUser(String[] csv){
        this.latitude = Double.parseDouble(csv[0]);
        this.longitude = Double.parseDouble(csv[1]);
        this.name = csv[2];
        this.coordinate = new Coordinate(Double.parseDouble(csv[0]),Double.parseDouble(csv[1]));
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
