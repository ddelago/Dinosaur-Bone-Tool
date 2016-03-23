package Datastore;

import java.util.Scanner;

/**
 * Kolten Sturgill
 * 1001089599
 * CSE 1325-002
 * 3/20/16.
 */
public class AirDinosaur extends Bone {
    double wingspan;

    /*public AirDinosaur(String name, int age, int id, float price, float length, float width, float height, float weight, float latitude, float longitude, String condition, String origin, String prospector, boolean isAvailable, Coordinate coordinate, double wingspan) {
        super(name,age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, isAvailable,coordinate);
        this.wingspan = wingspan;
    }*/

    public AirDinosaur(boolean isAvailable, int age, int id, float price, float length, float width, float height, float weight, double latitude, double longitude, String condition, String origin, String prospector, String name, double wingspan) {
        super(isAvailable, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, name);
        this.wingspan = wingspan;
        pricing(super.getCoordinate(), super.getPrice());
    }

    public double getWingspan() {
        return wingspan;
    }

    public void setWingspan(double wingspan) {
        this.wingspan = wingspan;
    }

    @Override
    public float pricing(Coordinate coordinate, float p) {
        System.out.printf("We recommend this price for this region: $\n Would you like to use this?\n");
        String response;
        Scanner in = new Scanner(System.in);
        float newPrice;
        try {
            response = in.next();
            if (response.equals("yes")) {
                return price;
            } else {
                System.out.print("What would you like to set the price as?");
                newPrice = in.nextFloat();
                price = newPrice;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return price;
    }
}
