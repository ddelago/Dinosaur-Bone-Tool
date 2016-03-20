/**
 * @author KoltenSturgill
 *
 */

import java.util.Scanner;


class Bones {                                                   //Bone class for creating and adding bones to an arraylist
    boolean isAvailable=true;
    int age, mapX, mapY, id;
    float price, length, width, height, weight, latitude, longitude;
    String condition, origin, prospector, name;
    Scanner input;

    public Bones() {
        input = new Scanner(System.in);
    }

    public Bones(String csv[]) {                               //Creating a bone object from a csv file
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
        prospector = csv[11];//.substring(0, csv[11].length() - 1);
        id = Integer.parseInt(csv[12]);
        isAvailable = Boolean.parseBoolean(csv[13]);
        mapX = Coordinate.longToX(longitude);
        mapY = Coordinate.latToY(latitude);
    }

    public void create(){                                     //Creating a bone object from the user
        try{
            System.out.print("Enter the:\nLongitude of the bone: ");
            longitude = input.nextFloat();
            System.out.print("Latitude of the bone: ");
            latitude = input.nextFloat();
            System.out.print("Price of the bone: $");
            price = input.nextFloat();
            System.out.print("Identification number: ");
            id = input.nextInt();
            System.out.print("Species: ");
            name = input.next();
            System.out.print("Age (in millions): ");
            age = input.nextInt();
            System.out.print("Dimensions of the bone with a space between each entry(length width height): ");
            length = input.nextFloat();
            width = input.nextFloat();
            height = input.nextFloat();
            System.out.print("Weight of the bone in kilograms: ");
            weight = input.nextFloat();
            System.out.print("Condition (Poor, Fair, Good, Excellent): ");
            condition = input.next();
            System.out.print("Country of Origin: ");
            origin = input.next();
            System.out.print("Prospector: ");
            prospector = input.next();

            mapX = Coordinate.longToX(longitude);
            mapY = Coordinate.latToY(latitude);

        }
        catch(Exception e){
            System.out.println("An error has occurred when submitting your bone.");
            System.out.println("Please try again");
            create();
        }
    }
    /*public void update(){                                       //Updates a bone with new values
        System.out.print("Enter the new Latitude: ");
        latitude = input.nextFloat();
        System.out.print("Enter the new Longitude: ");
        longitude = input.nextFloat();
        System.out.print("Enter the new price: ");
        price = input.nextFloat();
        mapX = Coordinate.longToX(longitude);
        mapY = Coordinate.latToY(latitude);

    }*/
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


    public int getID(){                                        //Getters and Setters
        return id;
     }

    public int getMapX(){
        return mapX;
    }

    public int getMapY(){
        return mapY;
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
