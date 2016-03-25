package Datastore;

import java.util.Random;
import java.util.Scanner;

/**
 * SeaCarnivore.java
 * Daniel Delago
 * Kolten Sturgill
 * 1001060927
 * 1001089599
 *
 * The SeaCarnivore class is the class that defines the SeaCarnivore dinosaur bone model,
 * this class extends the SeaDinosaur class
 *
 * Data Members:
 * String methodOfPropulsion
 *
 * Functions:
 * public SeaCarnivore(boolean isAvailable, int age,int id, float price, float length, float width, float height, float weight, double latitude, double longitude, String condition, String origin, String prospector, String name,boolean saltWater, String methodOfPropulsion)
 *
 * private String label(int i)
 *
 * public int randomInteger(int min, int max)
 *
 * public String getMethodOfPropulsion()
 *
 * public void setMethodOfPropulsion(String methodOfPropulsion)
 *
 * public float pricing(Coordinate coordinate, float p)
 *
 *
 */

public class SeaCarnivore extends SeaDinosaur {

    String methodOfPropulsion = label(randomInteger(0, 2));

    /*public SeaCarnivore(String name, int age, int id, float price, float length, float width, float height, float weight, float latitude, float longitude, String condition, String origin, String prospector, boolean isAvailable, Coordinate coordinate, boolean saltWater, String methodOfPropulsion) {
        super(name, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, saltWater);
        this.methodOfPropulsion = label(randomInteger(0, 2));
        System.out.print(getMethodOfPropulsion());
    }*/

    public SeaCarnivore(boolean isAvailable, int age,int id, float price, float length, float width, float height, float weight, double latitude, double longitude, String condition, String origin, String prospector, String name,boolean saltWater, String methodOfPropulsion) {
        super(isAvailable, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, name, saltWater);
        pricing(super.getCoordinate(), super.getPrice());
        this.methodOfPropulsion = methodOfPropulsion;
        this.methodOfPropulsion = label(randomInteger(0, 2));
        System.out.print(getMethodOfPropulsion());
    }

    private String label(int i) {
        if (i == 0){
            methodOfPropulsion = "flippers\n";
        }
        else if (i == 1){
            methodOfPropulsion = "tails\n";
        }
        else {
            methodOfPropulsion = "feet\n";
        }
        setMethodOfPropulsion(methodOfPropulsion);
        return methodOfPropulsion;
    }


    public int randomInteger(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    public String getMethodOfPropulsion() {
        return methodOfPropulsion;
    }

    public void setMethodOfPropulsion(String methodOfPropulsion) {
        this.methodOfPropulsion = methodOfPropulsion;
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
