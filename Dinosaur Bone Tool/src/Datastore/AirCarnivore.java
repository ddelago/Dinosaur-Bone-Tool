package Datastore;

/**
 * AirCarnivore.java
 * Daniel Delago
 * Kolten Sturgill
 * 1001060927
 * 1001089599
 *
 * The AirCarnivore class is the class that defines the AirCarnivore model
 * which inherits from the AirDinosaur class.
 *
 * Data Members:
 * int numberOfTeeth;
 *
 * Functions:
 * +public AirCarnivore(boolean isAvailable, int age, int id, float price, float length, float width, float height, float weight, double latitude, double longitude, String condition, String origin, String prospector, String name, double wingspan, int numberOfTeeth)
 *  Takes 15 parameters, returns nothing
 *  Creates an instance of AirCarnivore, sets the data member numberOfTeeth
 *
 * +public int getNumberOfTeeth()
 *  No parameters, returns an data member
 *  numberOfTeeth to an instance of AirCarnivore of type int.
 *  This is a getter, auto generated code.
 *
 * +public void setNumberOfTeeth(int numberOfTeeth)
 *  Takes an int and set's AirCarnivore numberOfTeeth data member to this int.
 */

public class AirCarnivore extends AirDinosaur {
    int numberOfTeeth = 20;

    public AirCarnivore(boolean isAvailable, int age, int id, float price, float length, float width, float height, float weight, double latitude, double longitude, String condition, String origin, String prospector, String name, double wingspan, int numberOfTeeth) {
        super(isAvailable, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, name, wingspan);
        this.numberOfTeeth = numberOfTeeth;
    }

    public int getNumberOfTeeth() {
        return numberOfTeeth;
    }

    public void setNumberOfTeeth(int numberOfTeeth) {
        this.numberOfTeeth = numberOfTeeth;
    }

}
