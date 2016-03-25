package Datastore;
/**
 * Continents.java
 * Daniel Delago
 * Kolten Sturgill
 * 1001060927
 * 1001089599
 *
 * The Coordinate class is the class that defines the Coordinate attribute for every bone, user, and map.
 *
 * Data Members:
 * int rowindex, collIndex, landOrWaterMap, available;
 * double longitude, latitude;
 *
 * Functions:
 * +public Coordinate(String newCoordData [])
 *  Takes a String array and assigns the attributes rowIndex, collIndex, and landOrWaterMap to these values.
 *
 * +public Coordinate(double longitude, double latitude)
 *  Takes two doubles and assign the Coordinates longitude and latitude attributes to these values.
 *  It then converts the values to int x and y and assigns the Coordinates rowIndex and collIndex attributes to these values.
 *
 * +public int[] getVals()
 *  Returns an array of the Coordinate objects rowIndex, collIndex, landOrwaterMap, and available attributes.
 *
 * +public int longToX(double longitude)
 *  Converts a longitude value to a x map index and returns it.
 *
 * +public int latToX(double latitude)
 *  Converts a latitude value to a y map index and returns it.
 * public int getRowIndex()
 *
 * public void setRowIndex(int rowIndex)
 * Setter, sets row index of Coordinate object
 *
 * public int getCollIndex()
 * Getter, gets Column Index of Coordinate object
 *
 * public void setCollIndex(int collIndex)
 * Setter, sets the Column index of Coordinate object
 *
 * public int getLandOrWaterMap()
 * Getter, gets weather Coordinate object is on land or water, 1 or 0
 *
 * public void setLandOrWaterMap(int landOrWaterMap)
 * Setter, sets int of weather Coordinate is on land or water, with a 1 or 0.
 *
 * public int getAvailable()
 * Getter, gets integer value
 *
 * public void setAvailable(int available)
 * Setter, sets integer value of weather 
 *
 * public double getLongitude()
 * Getter,
 *
 * public void setLongitude(double longitude)
 * Setter,
 *
 * public double getLatitude()
 * Getter,
 *
 * public void setLatitude(double latitude)
 * Setter,
 *
 */

public class Coordinate {                                               //Coordinate class for the map points

    public int rowIndex, collIndex, landOrWaterMap, available=-1;
    public double longitude, latitude;

    public Coordinate(String newCoordData []){                          //Parses data from map.txt
        rowIndex = Integer.parseInt(newCoordData[0]);
        collIndex = Integer.parseInt(newCoordData[1]);
        landOrWaterMap = Integer.parseInt(newCoordData[2]);
    }

    public Coordinate(double longitude, double latitude){               //Coordinate Constructor for csv File
        this.longitude=longitude;
        this.latitude=latitude;
        rowIndex=longToX(longitude);
        collIndex=latToY(latitude);
    }

    public int[] getVals(){                                     //Returns the values from a certain coordinate
        int[] coord = {this.rowIndex, this.collIndex, this.landOrWaterMap, this.available };
        return coord;
    }

    public int longToX(double longitude){                        //Converts longitude to x matrix points
        int mapX;
        longitude /= 6;
        if(longitude >= 0)
            longitude +=29;
        else if (longitude < 0)
            longitude = 30+longitude;
        mapX = (int)Math.round(longitude);
        //System.out.println(mapX);
        return mapX;
    }

    public int latToY(double latitude){                          //Converts latitude to y matrix points
        int mapY;
        latitude /= 9;
        if(latitude > 0){
            latitude *= -1;
            latitude +=10;
        }
        else if (latitude <= 0)
            latitude = 9 + Math.abs(latitude);
        mapY = (int)Math.round(latitude);
        //System.out.println(mapY);
        return mapY;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public int getCollIndex() {
        return collIndex;
    }

    public void setCollIndex(int collIndex) {
        this.collIndex = collIndex;
    }

    public int getLandOrWaterMap() {
        return landOrWaterMap;
    }

    public void setLandOrWaterMap(int landOrWaterMap) {
        this.landOrWaterMap = landOrWaterMap;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

}

