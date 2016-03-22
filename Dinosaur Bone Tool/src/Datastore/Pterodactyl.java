package Datastore;

/**
 * Kolten Sturgill
 * 1001089599
 * CSE 1325-002
 * 3/20/16.
 */
public class Pterodactyl extends AirCarnivore {
    boolean carryingCoconut;

    public Pterodactyl(String name, int age, int id, float price, float length, float width, float height, float weight, float latitude, float longitude, String condition, String origin, String prospector, double wingspan, int numberOfTeeth, boolean carryingCoconut) {
        super(name, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, wingspan, numberOfTeeth);
        this.carryingCoconut = carryingCoconut;
    }


}
