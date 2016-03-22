package Datastore;

import java.util.Formatter;

/**
 * Kolten Sturgill
 * 1001089599
 * CSE 1325-002
 * 3/20/16.
 */
public class Spinosaurus extends LandCarnivore {
    int numberOfSpines;

    public Spinosaurus(String name, int age, int id, float price, float length, float width, float height, float weight, float latitude, float longitude, String condition, String origin, String prospector, double speed, double groundSpeed, int numberOfSpines) {
        super(name, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, speed, groundSpeed);
        this.numberOfSpines = numberOfSpines;
        test();
    }

    public void test() {
        System.out.print(getCondition());
    }

    public int getNumberOfSpines() {
        return numberOfSpines;
    }

    public void setNumberOfSpines(int numberOfSpines) {
        this.numberOfSpines = numberOfSpines;
    }
}
