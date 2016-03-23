package Seller;

import Datastore.Coordinate;

/**
 * Kolten Sturgill
 * 1001089599
 * CSE 1325-002
 * 3/20/16.
 */
public class SellerUser {

    String name;
    String address;
    double x, y;
    Coordinate coordinate;

    public SellerUser(String name, String address, double x, double y) {

        this.name = name;
        this.address = address;
        this.x = x;
        this.y = y;
        this.coordinate = new Coordinate(x,y);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public String toString() {
        return name + "," + address + "," + x + "," + y;
    }
}
