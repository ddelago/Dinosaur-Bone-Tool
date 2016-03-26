package Datastore;

/**
 * Shastasaurus.java
 * Daniel Delago
 * Kolten Sturgill
 * 1001060927
 * 1001089599
 *
 * The Shastasaurus class is the class that defines the Shastasaurus dinosaur bone model,
 * this class extends the SeaCarnivore class
 *
 * Data Members:
 * public static int numberOfTeeth
 *
 * Functions:
 * public Shastasaurus(boolean isAvailable, int age, int id, float price, float length, float width, float height, float weight, double latitude, double longitude, String condition, String origin, String prospector, String name, boolean saltWater)
 * Takes 15 parameters and assigns the original values to the bone object.
 *
 * public static int getNumberOfTeeth()
 * returns numberOfTeeth
 *
 * public static int setNumberOfTeeth(int numberOfTeeth)
 * Takes an int and sets numberOfTeeth to it.
 *
 */
public class Shastasaurus extends SeaCarnivore {
    public static int numberOfTeeth = 0;

    /*public Shastasaurus(String name, int age,  int id, float price, float length, float width, float height, float weight, float latitude, float longitude, String condition, String origin, String prospector, boolean saltWater, String methodOfPropulsion) {
        super(name, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, isAvailable, coordinate, saltWater, methodOfPropulsion);
        setNumberOfTeeth(numberOfTeeth);
    }*/

    public Shastasaurus(boolean isAvailable, int age, int id, float price, float length, float width, float height, float weight, double latitude, double longitude, String condition, String origin, String prospector, String name, boolean saltWater, String methodOfPropulsion) {
        super(isAvailable, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, name, saltWater, methodOfPropulsion);
        setNumberOfTeeth(numberOfTeeth);
    }

    public static int getNumberOfTeeth() {
        return numberOfTeeth;
    }

    public static void setNumberOfTeeth(int numberOfTeeth) {
        Shastasaurus.numberOfTeeth = numberOfTeeth;
    }
}
