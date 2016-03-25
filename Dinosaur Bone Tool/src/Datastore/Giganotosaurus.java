package Datastore;

/**
 * Amargasaurus.java
 * Daniel Delago
 * Kolten Sturgill
 * 1001060927
 * 1001089599
 *
 * The Amargasaurus class is the class that defines the Amargasaurus dinosaur bone model
 *
 * Data Members:
 * double downloadCode
 *
 * Functions:
 *
 */

public class Giganotosaurus extends LandCarnivore {

    /*public Giganotosaurus(String name, int age, int id, float price, float length, float width, float height, float weight, float latitude, float longitude, String condition, String origin, String prospector,boolean isAvailable, Coordinate coordinate, double speed, double groundSpeed) {
        super(name,age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, isAvailable, coordinate, speed, groundSpeed);
        poorLittleMe();
    }*/

    public Giganotosaurus(boolean isAvailable, int age, int id, float price, float length, float width, float height, float weight, double latitude, double longitude, String condition, String origin, String prospector, String name, double speed, double groundSpeed) {
        super(isAvailable, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, name, speed, groundSpeed);
        poorLittleMe();
    }

    public void poorLittleMe(){
        System.out.format("Bigger than T. Rex, but not as cool.\n");
    }
}
