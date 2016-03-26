package Datastore;



/**
 * LandCarnivore.java
 * Daniel Delago
 * Kolten Sturgill
 * 1001060927
 * 1001089599
 *
 * The LandCarnivore class is the class that defines the LandCarnivore dinosaur bone model,
 * this class extends LandDinosaur
 *
 * Data Members:
 * double groundSpeed()
 *
 * Functions:
 * +public LandCarnivore(boolean isAvailable, int age, int id, float price, float length, float width, float height, float weight, double latitude, double longitude, String condition, String origin, String prospector, String name, double speed, double groundSpeed)
 *  Takes 15 parameters and assigns the original values to the bone object.
 *
 * public double getGroundSpeed()
 * Getter, gets ground speed attribute of LandCarnivore
 * public void setGroundSpeed(double groundSpeed)
 * Setter, sets ground speed attribute for LandCarnivore, takes a parameter of type double
 */


public class LandCarnivore extends LandDinosaur {
    double groundSpeed;

    public LandCarnivore(boolean isAvailable, int age, int id, float price, float length, float width, float height, float weight, double latitude, double longitude, String condition, String origin, String prospector, String name, double speed, double groundSpeed) {
        super(isAvailable, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, name, speed);
        this.groundSpeed = groundSpeed;
    }

    public double getGroundSpeed() {
        return groundSpeed;
    }

    public void setGroundSpeed(double groundSpeed) {
        this.groundSpeed = groundSpeed;
    }
}
