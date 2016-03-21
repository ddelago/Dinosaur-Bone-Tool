package Datastore;

/**
 * Kolten Sturgill
 * 1001089599
 * CSE 1325-002
 * 3/20/16.
 */
public class AirCarnivore extends AirDinosaur {
    int numberOfTeeth;

    public AirCarnivore(String name, int age, int id, float price, float length, float width, float height, float weight, float latitude, float longitude, String condition, String origin, String prospector, double wingspan, int numberOfTeeth) {
        super(name, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, wingspan);
        this.numberOfTeeth = numberOfTeeth;
    }

    public int getNumberOfTeeth() {
        return numberOfTeeth;
    }

    public void setNumberOfTeeth(int numberOfTeeth) {
        this.numberOfTeeth = numberOfTeeth;
    }
}
