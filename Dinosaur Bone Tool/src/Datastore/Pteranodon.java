
package Datastore;

/**
 * Pteranodon.java
 * Daniel Delago
 * Kolten Sturgill
 * 1001060927
 * 1001089599
 *
 * The Pteranodon class is the class that defines the Pteranodon dinosaur bone model,
 * this class extends the AirCarnivore class
 *
 * Data Members:
 * boolean availabilityOfSaddle = false;
 * double costOfSaddle = 1000;
 * String answer;
 * Formatter output;
 * Scanner input;
 *
 * Functions:
 * public Pteranodon(boolean isAvailable, int age, int id, float price, float length, float width, float height, float weight, double latitude, double longitude, String condition, String origin, String prospector, String name, double wingspan, int numberOfTeeth, boolean availabilityOfSaddle, double costOfSaddle, String answer) {
 * Takes 15 parameters and assigns the original values to the bone object.
 *
 * public boolean isAvailabilityOfSaddle()
 * returns availabilityOfSaddle
 *
 * public void setAvailabilityOfSaddle(boolean availabilityOfSaddle)
 * Takes a boolean value and sets availabilityOfSaddle to it.
 *
 * public double getCostOfSaddle()
 * Returns costOfSaddle
 *
 * public void setCostOfSaddle(double costOfSaddle)
 * Takes a double and sets costOfSaddle to it
 *
 * public float specialOffer(float price)
 * If availabilityOfSaddle is true, prompt the user to take an offer to change the costOfSaddle
 *
 */

import java.util.Formatter;
import java.util.Scanner;

/*One class for seven objects, int, identity, boolean array[row][column], make an array list of contentients*/


public class Pteranodon extends AirCarnivore {
    boolean availabilityOfSaddle = false;
    double costOfSaddle = 1000;
    String answer;
    Formatter output;
    Scanner input;

    public Pteranodon(boolean isAvailable, int age, int id, float price, float length, float width, float height, float weight, double latitude, double longitude, String condition, String origin, String prospector, String name, double wingspan, int numberOfTeeth, boolean availabilityOfSaddle, double costOfSaddle, String answer) {
        super(isAvailable, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, name,  wingspan, numberOfTeeth);
        this.availabilityOfSaddle = availabilityOfSaddle;
        this.costOfSaddle = costOfSaddle + 1000;
        specialOffer(price);
    }

    public boolean isAvailabilityOfSaddle() {
        return availabilityOfSaddle;
    }

    public void setAvailabilityOfSaddle(boolean availabilityOfSaddle) {
        this.availabilityOfSaddle = availabilityOfSaddle;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public float specialOffer(float price) {
        if (availabilityOfSaddle){
        output.format("We have a special offer of a saddle with this bone, would you like to take advantage of it?\n");
        answer = input.next().toLowerCase();
        switch (answer) {
            case ("yes"):
                setAnswer(answer);
                price = price + 1000;
                return price;
            case ("no"):
                setAnswer(answer);
                break;
            default:
                setAnswer("no");
        }
        }
        return price;
    }




}


