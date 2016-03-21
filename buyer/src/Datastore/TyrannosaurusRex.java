package Datastore;

import java.util.Random;

/**
 * Kolten Sturgill
 * 1001089599
 * CSE 1325-002
 * 3/20/16.
 */
public class TyrannosaurusRex extends LandCarnivore {
    int smellingRange = randomInteger(1,5);

    public TyrannosaurusRex(String name, int age, int id, float price, float length, float width, float height, float weight, float latitude, float longitude, String condition, String origin, String prospector, double speed, double groundSpeed, int smellingRange) {
        super(name,age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, speed, groundSpeed);
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
    public int randomInteger(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}