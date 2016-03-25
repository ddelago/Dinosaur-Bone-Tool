package Datastore;
import java.util.Random;

/**
 * Hylaeosaurus.java
 * Daniel Delago
 * Kolten Sturgill
 * 1001060927
 * 1001089599
 *
 * The Hylaeosaurus class is the class that defines the Hylaeosaurus dinosaur bone model,
 * this class extends LandHerbivore
 *
 * Data Members:
 * int armorThicknessLeft
 * int armorThicknessRight
 *
 * Functions:
 * +public Hylaeosaurus(boolean isAvailable, int age, int id, float price, float length, float width, float height, float weight, double latitude, double longitude, String condition, String origin, String prospector, String name, double speed, double gait, int armorThicknessLeft, int armorThicknessRight) {

 *  Takes 15 parameters and assigns the original values to the bone object.
 *
 *  public getArmorThicknessLeft()
 *
 *  public setArmorThicknessLeft(int armorThicknessLeft)
 *
 *  public getArmorThicknessRight()
 *
 *  public setArmorThicknessRight(int armorThicknessRight)
 *
 *  public private int randomIntegerRight(int min, int max)
 *
 *  private int randomIntegerLeft(int min, int max)
 */

public class Hylaeosaurus extends LandHerbivore {
    int armorThicknessLeft = randomIntegerLeft(1,3);
    int armorThicknessRight = randomIntegerRight(1,3) ;

    /*public Hylaeosaurus(String name, int age, int id, float price, float length, float width, float height, float weight, float latitude, float longitude, String condition, String origin, String prospector, double speed, double gait, int armorThicknessLeft, int armorThicknessRight) {
        super(name, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, isAvailable, coordinate, speed, gait);
        this.armorThicknessLeft = randomIntegerLeft(1,3);
        this.armorThicknessRight = randomIntegerRight(1,3);
        System.out.print("Armor thickness left: " + getArmorThicknessLeft() + "\n");
        System.out.print("Armor thickness right: " + getArmorThicknessRight() + "\n");
    }*/

    public Hylaeosaurus(boolean isAvailable, int age, int id, float price, float length, float width, float height, float weight, double latitude, double longitude, String condition, String origin, String prospector, String name, double speed, double gait, int armorThicknessLeft, int armorThicknessRight) {
        super(isAvailable, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, name, speed, gait);
        this.armorThicknessLeft = armorThicknessLeft;
        this.armorThicknessRight = armorThicknessRight;
    }

    public int getArmorThicknessLeft() {
        return armorThicknessLeft;
    }

    public void setArmorThicknessLeft(int armorThicknessLeft) {
        this.armorThicknessLeft = armorThicknessLeft;
    }

    public int getArmorThicknessRight() {
        return armorThicknessRight;
    }

    public void setArmorThicknessRight(int armorThicknessRight) {
        this.armorThicknessRight = armorThicknessRight;
    }

    //Random number generator, sets right armor thickness
    private int randomIntegerRight(int min, int max) {
        Random rand = new Random();
        setArmorThicknessRight(rand.nextInt((max - min) + 1) + min);
        return rand.nextInt((max - min) + 1) + min;
    }

    //Random number generator, sets left armor thickness
    private int randomIntegerLeft(int min, int max) {
        Random rand = new Random();
        setArmorThicknessLeft(rand.nextInt((max - min) + 1) + min);
        return rand.nextInt((max - min) + 1) + min;
    }

}
