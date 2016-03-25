
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
 *
 * public boolean isAvailabilityOfSaddle()
 *
 * public void setAvailabilityOfSaddle(boolean availabilityOfSaddle)
 *
 * public double getCostOfSaddle()
 *
 * public void setCostOfSaddle(double costOfSaddle)
 *
 * public String getAnswer()
 *
 * public void setAnswer(String answer)
 *
 * public float specialOffer(float price)
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

    /*public Pteranodon(String name, int age, int id, float price, float length, float width, float height, float weight, float latitude, float longitude, String condition, String origin, String prospector, double wingspan, int numberOfTeeth, boolean availabilityOfSaddle, double costOfSaddle) {
        super(name, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, wingspan, numberOfTeeth);
        this.availabilityOfSaddle = availabilityOfSaddle;
        this.costOfSaddle = costOfSaddle + 1000;
        specialOffer(price);
    }*/

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

    public double getCostOfSaddle() {
        return costOfSaddle;
    }

    public void setCostOfSaddle(double costOfSaddle) {
        this.costOfSaddle = costOfSaddle;
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


