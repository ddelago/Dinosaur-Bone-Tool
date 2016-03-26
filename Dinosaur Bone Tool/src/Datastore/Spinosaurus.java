package Datastore;

/**
 * Spinosaurus.java
 * Daniel Delago
 * Kolten Sturgill
 * 1001060927
 * 1001089599
 *
 * The Spinosaurus class is the class that defines the Spinosaurus dinosaur bone model,
 * this class extends the LandCarnivore class
 *
 * Data Members:
 * int numberOfSpines
 *
 * Functions:
 * public Triceratops(boolean isAvailable, int age, int id, float price, float length, float width, float height, float weight, double latitude, double longitude, String condition, String origin, String prospector, String name, boolean saltWater)
 * Takes 15 parameters and assigns the original values to the bone object.
 *
 * public void test()
 * Prints the condition of the Spinosaurus
 *
 */

public class Spinosaurus extends LandCarnivore {
    int numberOfSpines;

    public Spinosaurus(boolean isAvailable, int age, int id, float price, float length, float width, float height, float weight, double latitude, double longitude, String condition, String origin, String prospector, String name, double speed, double groundSpeed, int numberOfSpines) {
        super(isAvailable, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, name, speed, groundSpeed);
        this.numberOfSpines = numberOfSpines;
    }

    public void test() {
        System.out.print(getCondition());
    }

}
