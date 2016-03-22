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

    public SellerUser(double mapX, double mapY, String name) {
        this.longitude = mapX;
        this.latitude = mapY;
        this.name = name;
    }

    @Override
    public String toString() {
        return latitude + "," + latitude + "," + name ;
    }
}
