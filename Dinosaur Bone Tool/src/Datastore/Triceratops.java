package Datastore;

/**
 * Triceratops.java
 * Daniel Delago
 * Kolten Sturgill
 * 1001060927
 * 1001089599
 *
 * The Triceratops class is the class that defines the Triceratops dinosaur bone model,
 * this class extends the LandHerbivore class
 *
 * Data Members:
 * double cost
 *
 * Functions:
 * public Triceratops(boolean isAvailable, int age, int id, float price, float length, float width, float height, float weight, double latitude, double longitude, String condition, String origin, String prospector, String name, boolean saltWater)
 * Takes 15 parameters and assigns the original values to the bone object.
 *
 * public void setCost(double cost)
 * Takes a double and sets the cost to this value
 *
 * public double finalCost(float price)
 * Increases the cost by price
 *
 */
public class Triceratops extends LandHerbivore {
    double cost = 2500;

    public Triceratops(boolean isAvailable, int age, int id, float price, float length, float width, float height, float weight, double latitude, double longitude, String condition, String origin, String prospector, String name, double speed, double gait, double cost) {
        super(isAvailable, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, name, speed, gait);
        this.cost = cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double finalCost(float price){
        cost = cost + price;
        setCost(cost);
        return cost;
    }
}
