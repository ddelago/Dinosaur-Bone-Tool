package Seller;

import Datastore.Coordinate;

/**
 * Kolten Sturgill
 * 1001089599
 * CSE 1325-002
 * 3/20/16.
 */
public class SellerUser {
    double mapX;
    double mapY;
    String name;

    public SellerUser(double mapX, double mapY, String name) {
        this.mapX = mapX;
        this.mapY = mapY;
        this.name = name;
    }

    @Override
    public String toString() {
        return mapX + "," + mapY + "," + name ;
    }
}
