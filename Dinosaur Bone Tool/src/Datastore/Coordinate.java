package Datastore;
/**
 * Created by daniel on 2/5/16.
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
        System.out.println(mapX);
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
        System.out.println(mapY);
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

