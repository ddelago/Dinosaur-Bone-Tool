package Datastore;

import java.util.Random;

/**
 * Kolten Sturgill
 * 1001089599
 * CSE 1325-002
 * 3/20/16.
 */
public class Hylaeosaurus extends LandHerbivore {
    int armorThicknessLeft;
    int armorThicknessRight;

    public Hylaeosaurus(String name, int age, int id, float price, float length, float width, float height, float weight, float latitude, float longitude, String condition, String origin, String prospector, double speed, double gait, int armorThicknessLeft, int armorThicknessRight) {
        super(name, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, speed, gait);
        this.armorThicknessLeft = randomInteger(1,3);
        this.armorThicknessRight = randomInteger(1,3);
    }

    public int randomInteger(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

}
