package Datastore;

import java.util.Scanner;

/**
 * AirDinosaur.java
 * Daniel Delago
 * Kolten Sturgill
 * 1001060927
 * 1001089599
 *
 * The AirDinosaur class is the class that defines the AirDinosaur model
 * which inherits from the Bone class.
 *
 * Data Members:
 * double wingspan
 *
 * Functions:
 * +public AirDinosaur(boolean isAvailable, int age, int id, float price, float length, float width, float height, float weight, double latitude, double longitude, String condition, String origin, String prospector, String name, double wingspan, int numberOfTeeth)
 *  Takes 15 parameters, returns nothing
 *  Creates an instance of AirDinosaur, sets the data member wingspan
 *
 * +public double getWingspan()
 *  No parameters, returns data member wingspan to an instance of AirDinosaur of type double.
 *  This is a getter, auto generated code.
 *
 * +public void setWingspan(double wingspan)
 *  Takes a double and set's AirDinosaur wingspan data member to this double.
 *
 * +public float pricing(Coordinate coordinate, float p)
 *  Displays the suggested price and prompts the user if they want to change it.
 *  returns the new price.
 */

public class AirDinosaur extends Bone {
    double wingspan;

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
