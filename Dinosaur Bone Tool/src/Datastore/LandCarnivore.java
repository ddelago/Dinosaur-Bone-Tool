package Datastore;

/**
 * Kolten Sturgill
 * 1001089599
 * CSE 1325-002
 * 3/20/16.
 */
public class LandCarnivore extends LandDinosaur {
    double groundSpeed;

    public LandCarnivore(String name,int age, int id, float price, float length, float width, float height, float weight, float latitude, float longitude, String condition, String origin, String prospector, double speed, double groundSpeed) {
        super(name, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, speed);
        this.groundSpeed = groundSpeed;
    }

    public double getGroundSpeed() {
        return groundSpeed;
    }

    public void setGroundSpeed(double groundSpeed) {
        this.groundSpeed = groundSpeed;
    }
}
