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

    public int[] getVals(){                                     //Returns the values from a certain coordinate
        int[] coord = {this.rowIndex, this.collIndex, this.landOrWaterMap, this.available };
        return coord;
    }


    /*public int longToX(double longitude){                        //Converts longitude to x matrix points
        int mapX;
        longitude /= 6;
        if(longitude >= 0)
            longitude +=29;
        else if (longitude < 0)
            longitude = 30+longitude;
        mapX = (int)Math.round(longitude);
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
        return mapY;
    }
}*/
