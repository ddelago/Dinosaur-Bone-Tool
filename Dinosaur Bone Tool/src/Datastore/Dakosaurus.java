package Datastore;
/**
 * Dakosaurus.java
 * Daniel Delago
 * Kolten Sturgill
 * 1001060927
 * 1001089599
 *
 * The Dakosaurus class is the class that defines the Dakosaurus dinosaur bone model
 *
 * Data Members:
 * none
 *
 * Functions:
 * +public Dakosaurus(boolean isAvailable, int age, int id, float price, float length, float width, float height, float weight, double latitude, double longitude, String condition, String origin, String prospector, String name, boolean saltWater, String methodOfPropulsion)
 *  Takes 15 parameters and assigns to bone object.
 *
 * +public void printMessage()
 *  Prints "I survived the Dako!"
 */

public class Dakosaurus extends SeaCarnivore{

    public Dakosaurus(boolean isAvailable, int age, int id, float price, float length, float width, float height, float weight, double latitude, double longitude, String condition, String origin, String prospector, String name, boolean saltWater, String methodOfPropulsion) {
        super(isAvailable, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, name, saltWater, methodOfPropulsion);
        printMessage();
    }

    public void printMessage(){
        System.out.format("I survived the Dako!\n");
    }

}
