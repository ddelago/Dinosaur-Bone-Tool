package Datastore;

import java.util.Random;

/**
 * Kolten Sturgill
 * 1001089599
 * CSE 1325-002
 * 3/20/16.
 */
public class SeaCarnivore extends SeaDinosaur {

    String methodOfPropulsion = label(randomInteger(0, 2));

    public SeaCarnivore(String name, int age, int id, float price, float length, float width, float height, float weight, float latitude, float longitude, String condition, String origin, String prospector, boolean saltWater, String methodOfPropulsion) {
        super(name, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, saltWater);
        this.methodOfPropulsion = methodOfPropulsion;
    }

    private String label(int i) {
        if (i == 0){
            methodOfPropulsion = "flippers";
        }
        else if (i == 1){
            methodOfPropulsion = "tails";
        }
        else {
            methodOfPropulsion = "feet";
        }
        return methodOfPropulsion;
    }


    public int randomInteger(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    public String getMethodOfPropulsion() {
        return methodOfPropulsion;
    }

    public void setMethodOfPropulsion(String methodOfPropulsion) {
        this.methodOfPropulsion = methodOfPropulsion;
    }
}
