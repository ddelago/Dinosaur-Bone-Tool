package Datastore;

import java.util.Scanner;

/**
 * SeaDinosaur.java
 * Daniel Delago
 * Kolten Sturgill
 * 1001060927
 * 1001089599
 *
 * The SeaDinosaur class is the class that defines the SeaDinosaur dinosaur bone model,
 * this class extends the abstract Bone class
 *
 * Data Members:
 * boolean saltWater
 *
 * Functions:
 * public SeaDinosaur(boolean isAvailable, int age, int id, float price, float length, float width, float height, float weight, double latitude, double longitude, String condition, String origin, String prospector, String name, boolean saltWater)
 * Takes 15 parameters and assigns the original values to the bone object.
 *
 * public boolean isSaltWater()
 * Returns saltWater.
 *
 * public void setSaltWater(boolean saltWater)
 * Takes a boolean value and sets saltWater to it.
 *
 * public float pricing(Coordinate coordinate, float price)
 * Pricing function, overrides price from super.
 *
 */

public class SeaDinosaur extends Bone {
    boolean saltWater = false;

    public SeaDinosaur(boolean isAvailable, int age, int id, float price, float length, float width, float height, float weight, double latitude, double longitude, String condition, String origin, String prospector, String name, boolean saltWater) {
        super(isAvailable, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, name);
        this.saltWater = saltWater;
    }

    public boolean isSaltWater() {return saltWater;}

    public void setSaltWater(boolean saltWater) {
        this.saltWater = saltWater;
    }

    @Override
    public float pricing(Coordinate coordinate, float p) {
        System.out.printf("We recommend this price for this region: $%.2f\n Would you like to use this?\n",p);
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
