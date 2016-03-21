package Datastore;

/**
 * Kolten Sturgill
 * 1001089599
 * CSE 1325-002
 * 3/20/16.
 */
public class LandDinosaur extends Bone {
    double speed;

    public LandDinosaur(String name, int age,int id, float price, float length, float width, float height, float weight, float latitude, float longitude, String condition, String origin, String prospector, double speed) {
        super(name,age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector);
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return
                name +"," +
                        age + "," +
                        price + "," +
                        condition + "," +
                        longitude + "," +
                        latitude + "," +
                        origin + "," +
                        length + "," +
                        width + "," +
                        height + "," +
                        weight + "," +
                        prospector +","+
                        id + "," +
                        isAvailable + "\n";
    }
}
