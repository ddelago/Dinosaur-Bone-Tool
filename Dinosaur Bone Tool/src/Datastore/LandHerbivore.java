package Datastore;

/**
 * LandHerbivore.java
 * Daniel Delago
 * Kolten Sturgill
 * 1001060927
 * 1001089599
 *
 * The LandHerbivore class is the class that defines the LandHerbivore dinosaur bone model,
 * this class extends the LandDinosaur class
 *
 * Data Members:
 * double gait
 *
 * Functions:
 * public LandDinosaur(boolean isAvailable, int age, int id, float price, float length, float width, float height, float weight, double latitude, double longitude, String condition, String origin, String prospector, String name, double speed)
 *
 * public double getGait()
 *
 * public void setGait(double gait)
 *
 */
public class LandHerbivore extends LandDinosaur {
    double gait;

    /*public LandHerbivore(String name, int age, int id, float price, float length, float width, float height, float weight, float latitude, float longitude, String condition, String origin, String prospector, boolean isAvailable, Coordinate coordinate, double speed, double gait) {
        super(name,age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, speed);
        this.gait = gait;
    }*/

    public LandHerbivore(boolean isAvailable, int age, int id, float price, float length, float width, float height, float weight, double latitude, double longitude, String condition, String origin, String prospector, String name, double speed, double gait) {
        super(isAvailable, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, name, speed);
        this.gait = gait;
    }

    public double getGait() {
        return gait;
    }

    public void setGait(double gait) {
        this.gait = gait;
    }
}
