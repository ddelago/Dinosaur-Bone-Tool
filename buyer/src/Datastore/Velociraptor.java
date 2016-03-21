package Datastore;

import java.util.Formatter;
import java.util.Random;

/**
 * Kolten Sturgill
 * 1001089599
 * CSE 1325-002
 * 3/20/16.
 */
public class Velociraptor extends LandCarnivore {
    String size = printSize(randomInteger(0, 2));

    public Velociraptor(String name, int age,int id, float price, float length, float width, float height, float weight, float latitude, float longitude, String condition, String origin, String prospector, double speed, double groundSpeed, String size) {
        super(name, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, speed, groundSpeed);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    private String printSize(int i) {
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
