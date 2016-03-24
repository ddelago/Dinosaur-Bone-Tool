package Datastore;
/**
    * @author KoltenSturgill
    *
*/
import java.util.Scanner;


public abstract class Bone {

    boolean isAvailable = true;
    int age;
    int mapX;
    int mapY;
    int id;
    float price;
    float length;
    float width;
    float height;
    float weight;
    double latitude;
    double longitude;
    String condition;
    String origin;
    String prospector;
    String name;
    Scanner input;
    Coordinate coordinate;
    Continents continent=new Continents();


    public Bone(boolean isAvailable, int age,int id, float price, float length, float width, float height, float weight, double latitude, double longitude, String condition, String origin, String prospector, String name) {
        this.isAvailable = isAvailable;
        this.age = age;
        this.id = id;
        this.price = price;
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.latitude = latitude;
        this.longitude = longitude;
        this.condition = condition;
        this.origin = origin;
        this.prospector = prospector;
        this.coordinate = new Coordinate(longitude, latitude);
        this.name = name;
        this.continent = continent.returnContinents(coordinate);
        this.price=this.price+continent.priceIncrease;
    }

    public Bone(String csv[]) {                               //Creating a bone object from a csv file
        name = csv[0];
        age = Integer.parseInt(csv[1]);
        price = Float.parseFloat(csv[2]);
        condition = csv[3];
        longitude = Float.parseFloat(csv[4]);
        latitude = Float.parseFloat(csv[5]);
        origin = csv[6];
        length = Float.parseFloat(csv[7]);
        width = Float.parseFloat(csv[8]);
        height = Float.parseFloat(csv[9]);
        weight = Float.parseFloat(csv[10]);
        prospector = csv[11];
        id = Integer.parseInt(csv[12]);
        isAvailable = Boolean.parseBoolean(csv[13]);
        coordinate = new Coordinate(longitude, latitude);
    }

    public void newLat(){
        Scanner input = new Scanner(System.in);
        System.out.format("%s","Please enter a new lat:");
        float newLat = input.nextFloat();
        setLatitude(newLat);
    }

    public void newLong(){
        Scanner input = new Scanner(System.in);
        System.out.format("%s","Please enter a new long:");
        float newLong = input.nextFloat();
        setLongitude(newLong);
    }

    public void newPrice(){
        Scanner input = new Scanner(System.in);
        System.out.format("%s","Please enter a new price:");
        float newPrice = input.nextFloat();
        setPrice(newPrice);
    }
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    // Getters and Setters
    public int getID(){                                        //Getters and Setters
        return id;
     }

    public int getMapX(){
        return mapX;
    }

    public int getMapY(){
        return mapY;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMapX(int mapX) {
        this.mapX = mapX;
    }

    public void setMapY(int mapY) {
        this.mapY = mapY;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getProspector() {
        return prospector;
    }

    public void setProspector(String prospector) {
        this.prospector = prospector;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public abstract float pricing(Coordinate coordinate, float price);

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public String toString() {                                  //Used for converting the values back into a csv file
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
