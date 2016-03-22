package Datastore;

/**
 * Kolten Sturgill
 * 1001089599
 * CSE 1325-002
 * 3/20/16.
 */
public class Triceratops extends LandHerbivore {
    double cost = 2500;

    public Triceratops(String name,int age, int id, float price, float length, float width, float height, float weight, float latitude, float longitude, String condition, String origin, String prospector, double speed, double gait, double cost) {
        super(name, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, speed, gait);
        this.cost = finalCost(price);
        System.out.print(getCost());
    }

    public double getCost() {
        return cost;
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
