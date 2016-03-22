package Datastore;

/**
 * Kolten Sturgill
 * 1001089599
 * CSE 1325-002
 * 3/20/16.
 */
public class Shastasaurus extends SeaCarnivore {
    public static int numberOfTeeth = 0;

    public Shastasaurus(String name, int age,  int id, float price, float length, float width, float height, float weight, float latitude, float longitude, String condition, String origin, String prospector, boolean saltWater, String methodOfPropulsion) {
        super(name, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, saltWater, methodOfPropulsion);
        setNumberOfTeeth(numberOfTeeth);
    }

    public static int getNumberOfTeeth() {
        return numberOfTeeth;
    }

    public static void setNumberOfTeeth(int numberOfTeeth) {
        Shastasaurus.numberOfTeeth = numberOfTeeth;
    }
}
