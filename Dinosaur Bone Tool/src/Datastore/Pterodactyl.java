package Datastore;


/**
 * Pterodactyl.java
 * Daniel Delago
 * Kolten Sturgill
 * 1001060927
 * 1001089599
 *
 * The Pterodactyl class is the class that defines the Pterodactyl dinosaur bone model,
 * this class extends the AirCarnivore class
 *
 * Data Members:
 * boolean carryingCoconut;
 *
 * Functions:
 * public Pterodactyl(boolean isAvailable, int age, int id, float price, float length, float width, float height, float weight, double latitude, double longitude, String condition, String origin, String prospector, String name, double wingspan, int numberOfTeeth, boolean carryingCoconut) {
 * Takes 15 parameters and assigns the original values to the bone object.
 *
 * public boolean isCarryingCoconut()
 * Returns saltWater.
 *
 * public void setCarryingCoconut(boolean carryingCoconut)
 * Takes a boolean value and sets carryingCoconut to it.
 */
public class Pterodactyl extends AirCarnivore {
    boolean carryingCoconut;

    public Pterodactyl(boolean isAvailable, int age, int id, float price, float length, float width, float height, float weight, double latitude, double longitude, String condition, String origin, String prospector, String name, double wingspan, int numberOfTeeth, boolean carryingCoconut) {
        super(isAvailable, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, name, wingspan, numberOfTeeth);
        this.carryingCoconut = carryingCoconut;
    }

    public boolean isCarryingCoconut() {
        return carryingCoconut;
    }

    public void setCarryingCoconut(boolean carryingCoconut) {
        this.carryingCoconut = carryingCoconut;
    }
}
