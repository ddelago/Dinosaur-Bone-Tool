package Datastore;

import java.util.Random;

/**
 * TyrannosaurusRex.java
 * Daniel Delago
 * Kolten Sturgill
 * 1001060927
 * 1001089599
 *
 * The TyrannosaurusRex class is the class that defines the TyrannosaurusRex dinosaur bone model,
 * this class extends the LandCarnivore class
 *
 * Data Members:
 * int smellingRange
 *
 * Functions:
 * public TyrannosaurusRex(boolean isAvailable, int age, int id, float price, float length, float width, float height, float weight, double latitude, double longitude, String condition, String origin, String prospector, String name, boolean saltWater)
 * Takes 15 parameters and assigns the original values to the bone object.
 *
 * public int randomInteger(int min, int max)
 * Returns a random int between min and max
 *
 */

public class TyrannosaurusRex extends LandCarnivore {
    int smellingRange = randomInteger(1,5);

    /*public TyrannosaurusRex(String name, int age, int id, float price, float length, float width, float height, float weight, float latitude, float longitude, String condition, String origin, String prospector, double speed, double groundSpeed, int smellingRange) {
        super(name,age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, isAvailable, coordinate, speed, groundSpeed);
        this.smellingRange = smellingRange;
    }*/

    public TyrannosaurusRex(boolean isAvailable, int age, int id, float price, float length, float width, float height, float weight, double latitude, double longitude, String condition, String origin, String prospector, String name, double speed, double groundSpeed, int smellingRange) {
        super(isAvailable, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, name, speed, groundSpeed);
        this.smellingRange = smellingRange;
    }

    /**
     * Random Number Generator function
     * by Greg Case
     * http://stackoverflow.com/questions/363681/generating-random-integers-in-a-specific-range
     * */
    private int randomInteger(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}