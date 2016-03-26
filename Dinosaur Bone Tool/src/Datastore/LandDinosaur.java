package Datastore;

import java.util.Scanner;

/**
 * LandDinosaur.java
 * Daniel Delago
 * Kolten Sturgill
 * 1001060927
 * 1001089599
 *
 * The LandDinosaur class is the class that defines the LandDinosaur dinosaur bone model,
 * this class extends the abstract Bone class
 *
 * Data Members:
 * double speed
 *
 * Functions:
 * public LandDinosaur(boolean isAvailable, int age, int id, float price, float length, float width, float height, float weight, double latitude, double longitude, String condition, String origin, String prospector, String name, double speed)
 * Constructor, takes 15 parameters and sets the beginning values of LandDinosaur
 *
 * public double getSpeed()
 * Getter, gets the instance of LandDinosaur's speed
 * public void setSpeed(double speed)
 * Setter, sets the speed attribute of LandDinosaur, takes a single parameter of type double.
 * public float pricing(Coordinate coordinate, float p)
 * Pricing function, overrides price from super.
 */
public class LandDinosaur extends Bone {
    double speed;

    /*public LandDinosaur(String name, int age,int id, float price, float length, float width, float height, float weight, float latitude, float longitude, String condition, String origin, String prospector, double speed) {
        super(name,age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector);
        this.speed = speed;
    }*/

    public LandDinosaur(boolean isAvailable, int age, int id, float price, float length, float width, float height, float weight, double latitude, double longitude, String condition, String origin, String prospector, String name, double speed) {
        super(isAvailable, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, name);
        this.speed = speed;
        pricing(getCoordinate(), super.getPrice());
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public float pricing(Coordinate coordinate, float p) {
        //Continents continents = new Continents(coordinate);
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
