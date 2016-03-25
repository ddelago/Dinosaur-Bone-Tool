package Datastore;

/**
 * SeaDinosaur.java
 * Daniel Delago
 * Kolten Sturgill
 * 1001060927
 * 1001089599
 *
 * The SeaDinosaur class is the class that defines the SeaDinosaur dinosaur bone model,
 * this class extends the abstract Bone class
 *
 * Data Members:
 * boolean saltWater
 *
 * Functions:
 * public SeaDinosaur(boolean isAvailable, int age, int id, float price, float length, float width, float height, float weight, double latitude, double longitude, String condition, String origin, String prospector, String name, boolean saltWater)
 *
 * public boolean isSaltWater()
 *
 * public void setSaltWater(boolean saltWater)
 *
 * public float pricing(Coordinate coordinate, float price)
 *
 */

public class Spinosaurus extends LandCarnivore {
    int numberOfSpines;

    /*public Spinosaurus(String name, int age, int id, float price, float length, float width, float height, float weight, float latitude, float longitude, String condition, String origin, String prospector, double speed, double groundSpeed, int numberOfSpines) {
        super(name, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, isAvailable, coordinate, speed, groundSpeed);
        this.numberOfSpines = numberOfSpines;
        test();
    }*/

    public Spinosaurus(boolean isAvailable, int age, int id, float price, float length, float width, float height, float weight, double latitude, double longitude, String condition, String origin, String prospector, String name, double speed, double groundSpeed, int numberOfSpines) {
        super(isAvailable, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, name, speed, groundSpeed);
        this.numberOfSpines = numberOfSpines;
        //pricing(super.getCoordinate(), super.getPrice());
    }

    public void test() {
        System.out.print(getCondition());
    }

    public int getNumberOfSpines() {
        return numberOfSpines;
    }

    public void setNumberOfSpines(int numberOfSpines) {
        this.numberOfSpines = numberOfSpines;
    }

    /*@Override
    public float pricing(Coordinate coordinate, float p) {
        System.out.printf("We recommend this price for this region: $\n Would you like to use this?\n");
        String response;
        Scanner in = new Scanner(System.in);
        float newPrice;
        try {
            response = in.next();
            if (response.equals("yes")) {
                return price;
            } else {
                System.out.print("What would you like to set the price as?");
                newPrice = in.nextFloat();
                price = newPrice;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return price;
    }*/
}
