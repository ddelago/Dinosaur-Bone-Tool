package Datastore;

import java.util.Random;

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
 *
 * public boolean isSaltWater()
 *
 * public void setSaltWater(boolean saltWater)
 *
 * public float pricing(Coordinate coordinate, float price)
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

    public int getSmellingRange() {
        return smellingRange;
    }

    public void setSmellingRange(int smellingRange) {
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