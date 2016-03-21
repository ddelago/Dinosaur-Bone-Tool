package Datastore;

/**
 * Kolten Sturgill
 * 1001089599
 * CSE 1325-002
 * 3/20/16.
 */
public class LandHerbivore extends LandDinosaur {
    double gait;

    public LandHerbivore(String name,int age, int id, float price, float length, float width, float height, float weight, float latitude, float longitude, String condition, String origin, String prospector, double speed, double gait) {
        super(name,age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, speed);
        this.gait = gait;
    }

    public double getGait() {
        return gait;
    }

    public void setGait(double gait) {
        this.gait = gait;
    }
}
