/**
 * Created by daniel on 2/5/16.
 */
public class Coordinate {                                               //Coordinate class for the map points

    int rowIndex, collIndex, landOrWaterMap, available=-1;
    double longitude, latitude;


    public Coordinate(String newCoordData []){                                                //Parses data from map.txt
        rowIndex = Integer.parseInt(newCoordData[0]);
        collIndex = Integer.parseInt(newCoordData[1]);
        landOrWaterMap = Integer.parseInt(newCoordData[2]);
    }

    public int[] getVals(){                                     //Returns the values from a certain coordinate
        int[] coord = {this.rowIndex, this.collIndex, this.landOrWaterMap, this.available };
        return coord;
    }
}


//Add Long and Lat. For every bone,