package Datastore;

/**
 * Kolten Sturgill
 * 1001089599
 * CSE 1325-002
 * 3/20/16.
 */
public class SeaDinosaur extends Bone {
    boolean saltWater = false;

    public SeaDinosaur(String name, int age, int id, float price, float length, float width, float height, float weight, float latitude, float longitude, String condition, String origin, String prospector, boolean saltWater) {
        super(name, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector);
        this.saltWater = saltWater;
    }

    public boolean isSaltWater() {
        return saltWater;
    }

    public void setSaltWater(boolean saltWater) {
        this.saltWater = saltWater;
    }

}
