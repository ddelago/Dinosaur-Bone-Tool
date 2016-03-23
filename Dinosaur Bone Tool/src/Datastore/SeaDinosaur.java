package Datastore;

/**
 * Kolten Sturgill
 * 1001089599
 * CSE 1325-002
 * 3/20/16.
 */
public class SeaDinosaur extends Bone {
    boolean saltWater = false;

    /*public SeaDinosaur(String name, int age, int id, float price, float length, float width, float height, float weight, float latitude, float longitude, String condition, String origin, String prospector, boolean isAvailable, Coordinate coordinate, boolean saltWater) {
        super(name, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, isAvailable, coordinate);
        this.saltWater = saltWater;
    }*/

    public SeaDinosaur(boolean isAvailable, int age, int id, float price, float length, float width, float height, float weight, double latitude, double longitude, String condition, String origin, String prospector, String name, boolean saltWater) {
        super(isAvailable, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, name);
        this.saltWater = saltWater;
    }

    public boolean isSaltWater() {
        return saltWater;
    }

    public void setSaltWater(boolean saltWater) {
        this.saltWater = saltWater;
    }

    @Override
    public float pricing(Coordinate coordinate, float price) {
        return 0;
    }
}
