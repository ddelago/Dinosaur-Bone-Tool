package Datastore;


/**
 * Kolten Sturgill
 * 1001089599
 * CSE 1325-002
 * 3/20/16.
 */

public class Pterosaur extends AirCarnivore {
    String crest;

    public Pterosaur(String name, int age, int id, float price, float length, float width, float height, float weight, float latitude, float longitude, String condition, String origin, String prospector, double wingspan, int numberOfTeeth, String crest) {
        super(name, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, wingspan, numberOfTeeth);
        this.crest = crest;
    }

}

