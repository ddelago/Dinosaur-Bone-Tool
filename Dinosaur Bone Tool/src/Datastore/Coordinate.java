package Datastore;
/**
 * Created by daniel on 2/5/16.
 */
public class Coordinate {                                               //Coordinate class for the map points

    public int rowIndex, collIndex, landOrWaterMap, available=-1;
    public double longitude, latitude;


    public Coordinate(String newCoordData []){                                                //Parses data from map.txt
        rowIndex = Integer.parseInt(newCoordData[0]);
        collIndex = Integer.parseInt(newCoordData[1]);
        landOrWaterMap = Integer.parseInt(newCoordData[2]);
    }

    public Coordinate(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int[] getVals(){                                     //Returns the values from a certain coordinate
        int[] coord = {this.rowIndex, this.collIndex, this.landOrWaterMap, this.available };
        return coord;
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


//Add Long and Lat. For every bone,
