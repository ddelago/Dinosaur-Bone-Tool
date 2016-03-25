package Datastore;

import java.util.Random;

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

public class Velociraptor extends LandCarnivore {
    String size;

    /*public Velociraptor(String name, int age,int id, float price, float length, float width, float height, float weight, float latitude, float longitude, String condition, String origin, String prospector, double speed, double groundSpeed, String size) {
        super(name, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, isAvailable, coordinate, speed, groundSpeed);
        this.size = printSize(randomInteger(0, 2));
        System.out.print("Size of Velociraptor: " + getSize() + "\n");
    }*/

    public Velociraptor(boolean isAvailable, int age, int id, float price, float length, float width, float height, float weight, double latitude, double longitude, String condition, String origin, String prospector, String name, double speed, double groundSpeed, String size) {
        super(isAvailable, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, name, speed, groundSpeed);
        this.size = printSize(randomInteger(0, 2));
        System.out.print("Size of Velociraptor: " + getSize() + "\n");
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String printSize(int i) {
        if (i == 0){
            size = "small";
        }
        else if (i == 1){
            size = "medium";
        }
        else{
            size = "large";
        }
        setSize(size);
        return size;
    }


    public int randomInteger(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}
