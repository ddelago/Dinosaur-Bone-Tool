/**
 * @author KoltenSturgill
 *
 */

import java.util.Scanner;


class Bones {                                                               //Bone class for creating and adding bones to an arraylist
    boolean isAvailable=true;
    int age, mapX, mapY, id;
    float price, length, width, height, weight, latitude, longitude;
    String condition, origin, prospector, name;
    Scanner input;

    public Bones() {
        input = new Scanner(System.in);
    }

    public Bones(String csv[]) {                                           //Create bone object from file
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
        mapX = Coordinate.longToX(longitude);
        mapY = Coordinate.latToY(latitude);
    }

    public int getID(){
        return id;
     }                                      //Getters and Setters

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
                prospector + "," +
                id + "," +
                isAvailable + "\n";

    }
}
