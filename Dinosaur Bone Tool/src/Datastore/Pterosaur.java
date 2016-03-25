package Datastore;

/**
 * Pterosaur.java
 * Daniel Delago
 * Kolten Sturgill
 * 1001060927
 * 1001089599
 *
 * The Pterodactyl class is the class that defines the Pterosaur dinosaur bone model,
 * this class extends the AirCarnivore class
 *
 * Data Members:
 * boolean carryingCoconut;
 *
 * Functions:
 * public Pterodactyl(boolean isAvailable, int age, int id, float price, float length, float width, float height, float weight, double latitude, double longitude, String condition, String origin, String prospector, String name, double wingspan, int numberOfTeeth, boolean carryingCoconut) {
 *
 * public String getCrest()
 *
 * public void setCrest(String crest)
 *
 *
 */

public class Pterosaur extends AirCarnivore {
    String crest;

    /*public Pterosaur(String name, int age, int id, float price, float length, float width, float height, float weight, float latitude, float longitude, String condition, String origin, String prospector, double wingspan, int numberOfTeeth, String crest) {
        super(name, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, wingspan, numberOfTeeth);
        this.crest = crest;
    }*/

    public Pterosaur(boolean isAvailable, int age, int id, float price, float length, float width, float height, float weight, double latitude, double longitude, String condition, String origin, String prospector, String name, double wingspan, int numberOfTeeth, String crest) {
        super(isAvailable, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, name, wingspan, numberOfTeeth);
        this.crest = crest;
    }

    public String getCrest() {
        return crest;
    }

    public void setCrest(String crest) {
        this.crest = crest;
    }
}

