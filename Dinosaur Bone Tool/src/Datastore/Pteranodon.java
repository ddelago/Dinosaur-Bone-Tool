
package Datastore;







/**
 * Kolten Sturgill
 * 1001089599
 * CSE 1325-002
 * 3/20/16.
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

    public Pteranodon(String name, int age, int id, float price, float length, float width, float height, float weight, float latitude, float longitude, String condition, String origin, String prospector, double wingspan, int numberOfTeeth, boolean availabilityOfSaddle, double costOfSaddle) {
        super(name, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, wingspan, numberOfTeeth);
        this.availabilityOfSaddle = availabilityOfSaddle;
        this.costOfSaddle = costOfSaddle + 1000;
        specialOffer(price);
    }

    public float specialOffer(float price) {
        if (!availabilityOfSaddle){
        output.format("We have a special offer of a saddle with this bone, would you like to take advantage of it?\n");
        answer = input.next();
        switch (answer) {
            case ("yes"):
                price = price + 1000;
                return price;
            case ("no"):
                break;
            default:
                return price;
        }

        }
        return price;
    }




}


